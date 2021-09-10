package com.exadel.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class,
        resourceType = ManualCard.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class ManualCard {

    final protected static String RESOURCE_TYPE = "aemnews/components/content/manualcard";

    @ValueMapValue
    @Default(values = "empty")
    private String topic;

    @ValueMapValue
    @Default(values = "empty")
    private String article;

    @ValueMapValue
    @Default(values = "empty")
    private String link;

    public String getTopic() {
        return topic;
    }

    public String getArticle() {
        return article;
    }

    public String getLink() {
        return link;
    }
}
