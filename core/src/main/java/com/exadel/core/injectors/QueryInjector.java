package com.exadel.core.injectors;

import com.exadel.core.annotation.QueryParameter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.spi.DisposalCallbackRegistry;
import org.apache.sling.models.spi.Injector;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;

@Component(service = {Injector.class}, property = {Constants.SERVICE_RANKING + ":Integer=" + 4300})
public class QueryInjector implements Injector {

    public static final String NAME = "query-injector";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Object getValue(final Object adaptable, final String name, final Type type, final AnnotatedElement element,
                           final DisposalCallbackRegistry callbackRegistry) {

        final QueryParameter annotation = element.getAnnotation(QueryParameter.class);

        if (annotation == null) {
            return null;
        }

        SlingHttpServletRequest parentRealResource = getSlingHttpServletRequest(adaptable);
        if (parentRealResource == null) {
            return null;
        }

        if (parentRealResource.getParameter(annotation.name()) != null) {
            return parentRealResource.getParameter(annotation.name());
        } else {
            return annotation.defaultValue();
        }
    }

    protected SlingHttpServletRequest getSlingHttpServletRequest(Object adaptable) {
        if (adaptable instanceof SlingHttpServletRequest) {
            return ((SlingHttpServletRequest) adaptable);
        }
        return null;
    }
}
