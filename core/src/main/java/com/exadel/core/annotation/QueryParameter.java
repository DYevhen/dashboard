package com.exadel.core.annotation;

import com.exadel.core.injectors.QueryInjector;
import org.apache.sling.models.annotations.Source;
import org.apache.sling.models.spi.injectorspecific.InjectAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@InjectAnnotation
@Source(QueryInjector.NAME)
public @interface QueryParameter {
    String name();
    String defaultValue() default "";
}