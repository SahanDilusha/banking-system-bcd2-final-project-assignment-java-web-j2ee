package com.popcorntech.app.web.config;

import org.glassfish.jersey.internal.inject.AbstractBinder;

public class DependencyBinder extends AbstractBinder {

    @Override
    protected void configure() {
        System.out.println("DependencyBinder......");

    }
}
