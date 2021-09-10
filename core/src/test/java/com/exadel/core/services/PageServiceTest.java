package com.exadel.core.services;

import com.exadel.core.services.impl.PageServiceImpl;
import com.exadel.core.utility.ManualCard;
import org.junit.jupiter.api.Test;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

import java.util.Date;

public class PageServiceTest {

    private PageService fixture = new PageServiceImpl();
    private TestLogger logger = TestLoggerFactory.getTestLogger(fixture.getClass());

    @Test
    void checkContent() {
//        fixture.createCard(new ManualCard("Test Topic", "Test Article","testboard.net",new Date(10,05,2222)));
    }
}
