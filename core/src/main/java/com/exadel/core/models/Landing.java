package com.exadel.core.models;

import com.adobe.cq.social.commons.annotation.Parameter;
import com.adobe.xfa.Int;
import com.exadel.core.annotation.QueryParameter;
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
import org.apache.sling.models.annotations.injectorspecific.Self;
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

    @Self
    SlingHttpServletRequest request;

    @OSGiService
    private LandingService landingService;

    @ValueMapValue
    private List<ManualCard> cards;

    @QueryParameter(name = "pageNum", defaultValue = "0")
    private String pageNum;

    @QueryParameter(name = "itemsPerPage", defaultValue = "12")
    private String itemsPerPage;

    @PostConstruct
    public void init() {
        cards = landingService.getNews(Integer.parseInt(pageNum), Integer.parseInt(itemsPerPage));
    }
}
