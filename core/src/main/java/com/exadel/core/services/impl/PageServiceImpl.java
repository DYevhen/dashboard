package com.exadel.core.services.impl;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import com.exadel.core.services.PageService;
import com.exadel.core.services.RssImporter;
import com.exadel.core.utility.ManualCard;
import lombok.extern.slf4j.Slf4j;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Session;

@Slf4j
@Component(service = PageService.class)
public class PageServiceImpl implements PageService {

   /* @Reference
    private ResourceResolverFactory resolverFactory;*/

    @Reference
    private RssImporter rssImporter;

    private PageManager pageManager;
    private Session session;
    private final String CARD_SUPER = "dashboard/components/card";

    @Override
    public Page createCard(ManualCard manualCard) {
        /*ResourceResolver resourceResolver = null;
        Page page=null;
        ResourceResolver resolver = null;
        try {
            resolver = resolverFactory.getServiceResourceResolver(null);
            session = resolver.adaptTo(Session.class);
            pageManager = resolver.adaptTo(PageManager.class);
            page = pageManager.create("dashboard/components/content", manualCard.getTopic(), CARD_SUPER, "Dynamic Card");
        } catch (WCMException | LoginException e) {
            log.error("Cannot create card", e);
        }*/

        return null;
    }
}