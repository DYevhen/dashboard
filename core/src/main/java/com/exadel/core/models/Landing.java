package com.exadel.core.models;

import com.exadel.core.annotation.QueryParameter;
import com.exadel.core.services.LandingService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.Set;

@Getter
@Slf4j
@Model(adaptables = SlingHttpServletRequest.class,
        resourceType = Landing.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Landing {

    final static String RESOURCE_TYPE = "dashboard/components/content/gridcomponent";

    @Self
    SlingHttpServletRequest request;

    @OSGiService
    private LandingService landingService;

    @ValueMapValue
    private Set<ManualCard> cards;

    @QueryParameter(name = "pageNum", defaultValue = "0")
    private String pageNum;

    @QueryParameter(name = "itemsPerPage", defaultValue = "9")
    private String itemsPerPage;

    @QueryParameter(name = "searchText", defaultValue = "")
    private String searchText;

    @PostConstruct
    public void init() {
        cards = landingService.getNews(searchText.toLowerCase(), Integer.parseInt(pageNum), Integer.parseInt(itemsPerPage));
    }
}
