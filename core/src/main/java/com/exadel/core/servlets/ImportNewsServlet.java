package com.exadel.core.servlets;

import com.exadel.core.services.PageService;
import com.exadel.core.services.RssImporter;
import lombok.extern.slf4j.Slf4j;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.GregorianCalendar;

@Slf4j
@Component(service = Servlet.class, property = {
        "sling.servlet.methods="+HttpConstants.METHOD_POST
})
@SlingServletPaths(value = "/content/dashboard/import-news/start")
/*@SlingServletResourceTypes(
        resourceTypes = "dashboard/components/granite-page",
        methods = HttpConstants.METHOD_GET,
        extensions = "html",
        selectors = "granite-page-get")*/

public class ImportNewsServlet extends SlingAllMethodsServlet {

    @Reference
    private PageService pageService;

    @Reference
    private RssImporter rssImporter;

    @Override
    protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse resp) throws IOException {
        log.info("======================================SERVLET START=============================================");
        pageService.createCards(rssImporter.getData());
        pageService.setLastExecution(new GregorianCalendar());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        resp.setContentType("text/plain");
        resp.setStatus(SlingHttpServletResponse.SC_ACCEPTED);
        resp.getWriter().print("Success!");
        resp.sendRedirect("/content/dashboard/import-news.html");
        log.info("======================================SERVLET END===============================================");

    }
}
