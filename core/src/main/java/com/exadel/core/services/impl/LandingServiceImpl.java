package com.exadel.core.services.impl;

import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.exadel.core.models.ManualCard;
import com.exadel.core.services.LandingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component(service = LandingService.class)
public class LandingServiceImpl implements LandingService {

    @Reference
    private ResourceResolverFactory resolverFactory;

    private final String LANDING_PATH = "/content/dashboard/us/en/landing";
    private final String USER = "dashboardserviceuser";
    private PageManager pageManager;
    private Session session;

    @Override
    public void fillLanding() {
        final String query = "SELECT * FROM [cq:PageContent] AS node " +
                "WHERE ISDESCENDANTNODE ([/content/dashboard/news]) " +
                "AND node.[isPosted]='false'";
        QueryResult queryResult;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(ResourceResolverFactory.SUBSERVICE, USER);
        try (ResourceResolver resolver = resolverFactory.getServiceResourceResolver(paramMap)) {
            session = resolver.adaptTo(Session.class);
            pageManager = resolver.adaptTo(PageManager.class);
            queryResult = session.getWorkspace().getQueryManager().createQuery(query,"JCR-SQL2").execute();
            Node root = pageManager.getPage(LANDING_PATH).adaptTo(Node.class).getNode("jcr:content");
            if (root == null) {
                throw new RepositoryException("jcr:content is null");
            }
            NodeIterator iterator = queryResult.getNodes();
            while (iterator.hasNext()) {
                Node content = iterator.nextNode();
                createCard(content,root);
            }
            session.save();
        } catch (LoginException | RepositoryException e) {
            log.error("Cannot fill landing page", e);
        }
    }

    private void createCard(Node content, Node root) throws RepositoryException {
        String resourceType = "dashboard/components/content/manualcard";
        String link = String.format("http://localhost:4502%s.html", content.getParent().getPath());
        Node news = root.addNode(String.format("root/container/gridcomponent/null/%s",content.getProperty("Name").getValue()));
        news.setProperty("sling:resourceType", resourceType);
        Node description = content.getNode("root/container/text");
        Node image = content.getNode("root/container/myimage");
        Node topic = content.getNode("root/container/text_1716190574");
        news.setProperty("article", description.getProperty("text").getValue());
        news.setProperty("topic", topic.getProperty("text").getValue());
        news.setProperty("textIsRich", "true");
        news.setProperty("link",link);
        content.setProperty("isPosted", true);
    }

    @Override
    public List<ManualCard> getNews(int pageNum, int itemsPerPage) {
        if (itemsPerPage == 0) {
            itemsPerPage = 10;
        }
        List<ManualCard> news = new ArrayList<>();
        final String query = "SELECT * FROM [nt:unstructured] AS node WHERE ISDESCENDANTNODE ([/content/dashboard/news])" +
                "AND node.[sling:resourceType]='dashboard/components/container' AND [jcr:path] LIKE '%root/%'";
        QueryResult queryResult;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(ResourceResolverFactory.SUBSERVICE, USER);
        try (ResourceResolver resolver = resolverFactory.getServiceResourceResolver(paramMap)) {
            session = resolver.adaptTo(Session.class);
            pageManager = resolver.adaptTo(PageManager.class);
            Query q = session.getWorkspace().getQueryManager().createQuery(query,"JCR-SQL2");
            q.setLimit(itemsPerPage);
            q.setOffset(pageNum);
            queryResult = q.execute();
            NodeIterator iterator = queryResult.getNodes();
            while (iterator.hasNext()) {
                Node content = iterator.nextNode();
                ManualCard card = resolver.getResource(content.getPath()).adaptTo(ManualCard.class);
                news.add(card);
            }
        }catch (LoginException | RepositoryException e){
            log.error("Cannot get news", e);
        }
        return news;
    }
}
