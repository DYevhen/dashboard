package com.exadel.core.schedulers;

import com.exadel.core.services.LandingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Slf4j
@Designate(ocd = LandingScheduler.Config.class)
@Component(service = Runnable.class)
public class LandingScheduler implements Runnable{

    @ObjectClassDefinition(name = "Landing scheduler",
            description = "Simple landing scheduler")
    public static @interface Config {

        @AttributeDefinition(name = "Cron-job expression")
        String scheduler_expression() default "0 0/1 * 1/1 * ? *";

        @AttributeDefinition(name = "Concurrent task",
                description = "Whether or not to schedule this task concurrently")
        boolean scheduler_concurrent() default true;
    }

    @Reference
    private Scheduler scheduler;

    @Reference
    private LandingService landingService;

    @Activate
    protected void activate(final NewsImportScheduler.Config config) {
    }

    @Override
    public void run() {
        log.info("===============================================================" +
                "LANDING SCHEDULER START=================================================");
//        landingService.fillLanding();
        log.info("===============================================================" +
                "LANDING SCHEDULER END====================================================");
    }
}
