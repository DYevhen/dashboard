package com.exadel.core.services;

import com.day.cq.wcm.api.Page;
import com.exadel.core.utility.ManualCard;

import java.util.Date;
import java.util.List;

public interface PageService {

    Page createCard(ManualCard manualCard, Date lastExecution);

    List<Page> createCards(List<ManualCard> cards, Date lastExecution);
}
