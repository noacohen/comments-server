package services;

import javax.inject.*;
import play.inject.ApplicationLifecycle;
import play.Environment;

import services.CommentsService;

@Singleton
public class ApplicationStart {
	@Inject
	public ApplicationStart(ApplicationLifecycle lifecycle, Environment environment) {
		CommentsService.initializeComments();
	}
}