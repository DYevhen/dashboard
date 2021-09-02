package com.exadel.core.services;

import com.exadel.core.services.impl.RssImporterImpl;
import org.junit.jupiter.api.Test;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

public class RssImporterImplTest {

    private RssImporterImpl fixture = new RssImporterImpl();
    private TestLogger logger = TestLoggerFactory.getTestLogger(fixture.getClass());

    @Test
    void checkContent() {
        fixture.getData().forEach(System.out::println);
    }
}
