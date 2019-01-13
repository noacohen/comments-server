package services;

import javax.inject.*;
import play.inject.ApplicationLifecycle;
import play.Environment;

import services.CommentsService;

/**
 * This service handle all the application initialization
 */
@Singleton
public class ApplicationStartService {
	@Inject
	public ApplicationStartService(ApplicationLifecycle lifecycle, Environment environment) {
		CommentsService.initializeComments();
	}
}