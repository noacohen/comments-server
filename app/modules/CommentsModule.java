package modules;

import com.google.inject.AbstractModule;

import services.ApplicationStart;

public class CommentsModule extends AbstractModule {
    protected void configure() {
        bind(ApplicationStart.class).asEagerSingleton();
    }
}