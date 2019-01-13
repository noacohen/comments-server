package controllers;

import java.util.HashSet;

import models.Comment;
import play.libs.Json;
import play.mvc.*;
import services.CommentsService;

/**
 * This controller contains an action to handle HTTP requests to get comments
 */
public class CommentsController extends Controller {
	public Result comments(String postId) {
    	try {
        	HashSet<Comment> comments = CommentsService.getCommentsByPostId(Integer.parseInt(postId));
        	return ok(Json.toJson(comments));
    	} catch (Exception e) {
    		String message = String.format("Error occured while trying to fetch comments with postId: %s, Error: %s", postId, e.getMessage());
    		System.out.println(message);
    		return internalServerError(Json.toJson(message));
    	}
    }
}
