package com.exadel.core.services.impl;

import com.exadel.core.utility.ManualCard;
import com.exadel.core.services.RssImporter;
import com.rometools.rome.feed.rss.Enclosure;
import com.rometools.rome.feed.synd.SyndEnclosure;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component(service = RssImporter.class)
public class RssImporterImpl implements RssImporter {

    private static final Logger LOG = LoggerFactory.getLogger(RssImporterImpl.class);

    @Override
    public List<ManualCard> getData() {
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = null;
        try{
            URL feedUrl = new URL("https://www.nasa.gov/rss/dyn/breaking_news.rss");
            feed = input.build(new XmlReader(feedUrl));
        } catch (IOException | FeedException e) {
            LOG.error(e.getMessage());
        }
        assert feed != null;

        return feed.getEntries().stream().map(x -> new ManualCard(x.getTitle(),
                x.getDescription().getValue(),
                x.getUri(),
                x.getPublishedDate(),
                x.getEnclosures().stream()
                        .map(SyndEnclosure::getUrl)
                        .collect(Collectors.toList())
                        .get(0))).collect(Collectors.toList());
    }
}
