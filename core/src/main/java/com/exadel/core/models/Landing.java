package com.exadel.core.models;

import com.exadel.core.services.LandingService;
import lombok.Getter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.List;

@Getter
@Slf4j
@Model(adaptables = SlingHttpServletRequest.class,
        resourceType = Landing.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Landing {

    final static String RESOURCE_TYPE = "dashboard/components/content/gridcomponent";

    @OSGiService
    private LandingService landingService;

    @ValueMapValue
    private List<ManualCard> cards;

    @RequestAttribute(name = "pageNum")
    private int pageNum;

    @RequestAttribute(name = "itemsPerPage")
    private int itemsPerPage;

    @PostConstruct
    public void init() {
        cards = landingService.getNews(pageNum, itemsPerPage);
    }
}
