package modules;

import com.google.inject.AbstractModule;

import services.ApplicationStartService;

public class CommentsModule extends AbstractModule {
    protected void configure() {
        bind(ApplicationStartService.class).asEagerSingleton();
    }
}