package com.exadel.core.services.impl;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import com.exadel.core.services.PageService;
import com.exadel.core.utility.ManualCard;
import lombok.extern.slf4j.Slf4j;
import org.apache.jackrabbit.JcrConstants;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component(service = PageService.class)
public class PageServiceImpl implements PageService {

    @Reference
    private ResourceResolverFactory resolverFactory;

    private final String USER = "dashboardserviceuser";
    private PageManager pageManager;
    private Session session;
    private final String PAGE_TAMPLATE = "/conf/dashboard/settings/wcm/templates/article_2";
    private final String PAGE_PATH = "/content/dashboard/news";

    @Override
    public Page createCard(ManualCard manualCard) {
        ResourceResolver resourceResolver = null;
        Page page = null;
        ResourceResolver resolver;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(ResourceResolverFactory.SUBSERVICE, USER);
        try {
            resolver = resolverFactory.getServiceResourceResolver(paramMap);
            session = resolver.adaptTo(Session.class);
            pageManager = resolver.adaptTo(PageManager.class);
            page = pageManager.create(PAGE_PATH, "news_page", PAGE_TAMPLATE, "News");
            if (page != null) {
                Node newNode = page.adaptTo(Node.class);
                assert newNode != null;
                Node cont = newNode.getNode("jcr:content");
                if (cont != null) {
                    Node description = cont.getNode("root/container/text");
                    Node image = cont.getNode("root/container/myimage");
                    Node topic = cont.getNode("root/container/text_1716190574");
                    image.setProperty("link", manualCard.getImage());
                    image.setProperty("sling:resourceType", "dashboard/components/content/myImage");
                    topic.setProperty("text", String.format("<h2>%s</h2>", manualCard.getTopic()));
                    topic.setProperty("textIsRich", "true");
                    description.setProperty("text", manualCard.getArticle());
                    session.save();
                }
            }
        } catch (WCMException | LoginException | RepositoryException e) {
            log.error("Cannot create page", e);
        }
        return page;
    }

    @Override
    public List<Page> createCards(List<ManualCard> cards) {
        return cards.stream().map(this::createCard).collect(Collectors.toList());
    }
}
