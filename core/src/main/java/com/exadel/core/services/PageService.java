package com.exadel.core.services;

import com.day.cq.wcm.api.Page;
import com.exadel.core.utility.ManualCard;

import java.util.Calendar;
import java.util.List;

public interface PageService {

    Page createCard(ManualCard manualCard);

    List<Page> createCards(List<ManualCard> cards);

    public Calendar getLastExecution();

    public void setLastExecution(Calendar date);
}
