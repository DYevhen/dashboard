package com.exadel.core.services.impl;

import com.apptastic.rssreader.Item;
import com.apptastic.rssreader.RssReader;
import com.exadel.core.services.RssImporter;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component(service = RssImporter.class)
public class RssImporterImpl implements RssImporter {

    private static final Logger LOG = LoggerFactory.getLogger(RssImporterImpl.class);
    RssReader reader;

    @Activate
    public void activate() {
        LOG.info("RSS IMPORTER is ACTIVATED!");
    }

    @Override
    public String getData() {
        reader = new RssReader();
        Stream<Item> rssFeed = null;
        try {
            rssFeed = reader.read("http://rss.cnn.com/rss/cnn_topstories.rss");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        List<Item> articles = rssFeed.filter(i -> i.getTitle().equals(Optional.of("space")))
                                    .collect(Collectors.toList());
        return articles.toString();
    }
}
