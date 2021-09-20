package com.exadel.core.models;

import lombok.Getter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Getter
@Model(adaptables = {Resource.class, SlingHttpServletRequest.class} ,
        resourceType = ManualCard.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ManualCard {

    final protected static String RESOURCE_TYPE = "dashboard/components/content/manualcard";

    @ValueMapValue(name = "text_1716190574/text")
    private String topic;

    @ValueMapValue(name = "text/text")
    private String article;

    @ValueMapValue(name = "myimage/link")
    private String image;

    @ValueMapValue(name = "button/link")
    private String link;
}
