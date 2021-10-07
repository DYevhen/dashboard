package com.exadel.core.services;
import com.exadel.core.models.ManualCard;
import org.apache.sling.api.resource.ResourceResolver;

import java.util.List;

public interface LandingService {

    List<ManualCard> getNews(ResourceResolver resolver, String searchText, String sortBy, int pageNum, int itemsPerPage, String language);
}
