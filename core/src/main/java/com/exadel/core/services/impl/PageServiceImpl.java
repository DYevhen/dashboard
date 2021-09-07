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
    private final String PAGE_TAMPLATE = "/apps/dashboard/components/content/article";
    private final String PAGE_PATH = "/content/dashboard/news";

    @Override
    public Page createCard(ManualCard manualCard) {
        ResourceResolver resourceResolver = null;
        Page page=null;
        ResourceResolver resolver = null;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(ResourceResolverFactory.SUBSERVICE, USER);
        try {
            resolver = resolverFactory.getServiceResourceResolver(paramMap);
            session = resolver.adaptTo(Session.class);
            pageManager = resolver.adaptTo(PageManager.class);
            page = pageManager.create(PAGE_PATH, "news", PAGE_TAMPLATE, "Dynamic Card");
            if (page != null) {
//                user = resolver.getUserID();

                Node newNode = page.adaptTo(Node.class);
                Node cont = newNode.getNode("jcr:content");
                if (cont != null) {
                    Node rootNode = session.getRootNode();
                    String path = rootNode.getPath();
                    Node parNode = JcrUtils.getNodeIfExists(cont, PAGE_PATH);
                    Node imageNode = JcrUtils.getOrCreateByPath(parNode.getPath() + "/image", JcrConstants.NT_UNSTRUCTURED, session);
                    Node textNode = JcrUtils.getNodeIfExists(parNode, "text");
                    imageNode.setProperty("sling:resourceType", "foundation/components/image");
                    imageNode.setProperty("fileReference", "/content/dam/we-retail-screens/we-retail-instore-logo.png");
                    textNode.setProperty("text", "<p>This page is created using page manager</p>");
                    session.save();
                }
            }
        } catch (WCMException | LoginException | RepositoryException e) {
            log.error("Cannot create card", e);
        }

        return page;
    }

    @Override
    public List<Page> createCards(List<ManualCard> cards) {
        return cards.stream().map(this::createCard).collect(Collectors.toList());
    }
}
