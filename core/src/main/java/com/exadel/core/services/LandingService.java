package com.exadel.core.services;
import com.exadel.core.models.ManualCard;

import java.util.Set;

public interface LandingService {

    Set<ManualCard> getNews(String searchText, int pageNum, int itemsPerPage);
}
