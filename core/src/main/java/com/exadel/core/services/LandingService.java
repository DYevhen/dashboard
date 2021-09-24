package com.exadel.core.services;
import com.exadel.core.models.ManualCard;

import java.util.List;

public interface LandingService {

    List<ManualCard> getNews(String searchText, String sortBy, int pageNum, int itemsPerPage);
}
