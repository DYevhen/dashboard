package com.exadel.core.models.impl;

import com.exadel.core.models.Card;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        adapters = Card.class)
public class CardImpl implements Card {

    @Inject
    @Default(values = "STUNNING NEWS!")
    String title;

    @Inject
    @Default(values = "Very interesting text.")
    String mainText;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getMainText() {
        return mainText;
    }
}
