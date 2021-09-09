package com.exadel.core.models;

import lombok.extern.slf4j.Slf4j;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Slf4j
@Model(adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Card {

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
