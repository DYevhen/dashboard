package com.exadel.core.schedulers;

import com.exadel.core.utility.ManualCard;
import com.exadel.core.services.PageService;
import com.exadel.core.services.RssImporter;
import lombok.extern.slf4j.Slf4j;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import java.util.Date;
import java.util.List;

@Slf4j
@Designate(ocd = NewsImportScheduler.Config.class)
@Component(service = Runnable.class)
public class NewsImportScheduler implements Runnable {

    @ObjectClassDefinition(name = "News scheduler",
            description = "Simple news scheduler")
    public static @interface Config {

        @AttributeDefinition(name = "Cron-job expression")
        String scheduler_expression() default "0 0/1 * 1/1 * ? *";

        @AttributeDefinition(name = "Concurrent task",
                description = "Whether or not to schedule this task concurrently")
        boolean scheduler_concurrent() default false;
    }

    @Reference
    private PageService pageService;

    @Reference
    private RssImporter rssImporter;

    List<ManualCard> cards;
    private Date lastExecution = new Date(1212121212121L);;

    @Reference
    private Scheduler scheduler;

    @Activate
    protected void activate(final Config config) {
    }

    @Override
    public void run() {
        log.info("\n===========================NEWS IMPORT SCHEDULER=================================");
        cards = rssImporter.getData();
        pageService.createCards(cards, lastExecution);
        lastExecution = new Date();
        log.info(String.format("\n=============================%d====================================================",
                lastExecution.getTime()));
    }
}
