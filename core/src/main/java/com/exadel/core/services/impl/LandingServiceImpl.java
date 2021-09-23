package com.exadel.core.services.impl;

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
import java.util.*;

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
    public Set<ManualCard> getNews(String searchText, int pageNum, int itemsPerPage) {
        Set<ManualCard> news = new HashSet<>();
        String query;
        final String defaultQuery = "SELECT * FROM [nt:unstructured] AS node WHERE ISDESCENDANTNODE ([/content/dashboard/news])" +
                    "AND node.[sling:resourceType]='dashboard/components/container' AND [jcr:path] LIKE '%root/%' ORDER BY node.[pubDate]";
        String withKeyWord =
                "SELECT node.* FROM [nt:unstructured] AS node " +
                "INNER JOIN [nt:unstructured] AS child ON ISDESCENDANTNODE (child, node) " +
                "WHERE ISDESCENDANTNODE (node, '/content/dashboard/news') " +
                "AND node.[sling:resourceType]='dashboard/components/container' " +
                "AND node.[jcr:path] LIKE '%root/%' " +
                "AND LOWER(child.[text]) LIKE '%"+searchText+"%' " +
                "ORDER BY node.[pubDate]";
        if (searchText.equals("") || searchText.equals("null")) {
            query = defaultQuery;
        } else {
            query = withKeyWord;
        }
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
