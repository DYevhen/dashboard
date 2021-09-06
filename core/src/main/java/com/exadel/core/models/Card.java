package com.exadel.core.models;

import com.day.cq.wcm.api.Page;
import com.exadel.core.services.PageService;
import com.exadel.core.utility.ManualCard;
import lombok.extern.slf4j.Slf4j;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Date;

@Slf4j
@Model(adaptables = SlingHttpServletRequest.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Card  {
/*
    @OSGiService
    RssImporter rssImporter;*/

    @OSGiService
    PageService pageService;

    @PostConstruct
    private void init() {
        Page page = pageService.createCard(new ManualCard("t", "a", "b", new Date(1,2,2222)));
        log.info(page.getTitle()+" "+page.getDescription());
    }

    @Inject
    @Default(values = "STUNNING NEWS!")
    String title;

    @Inject
    @Default(values = "Very interesting text.")
    String mainText;

    public String getTitle() {
        return title;
    }

    public String getMainText() {
        return mainText;
    }
}
