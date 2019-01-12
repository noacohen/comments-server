package controllers;

import java.util.HashSet;

import Models.Comment;

import play.libs.Json;
import play.mvc.*;
import services.CommentsService;

public class CommentsController extends Controller {
	public Result comments(String postId) {
    	try {
        	HashSet<Comment> comments = CommentsService.getCommentsByPostId(Integer.parseInt(postId));
        
        	return ok(Json.toJson(comments));
    	} catch (Exception e) {
    		return badRequest(Json.toJson(e.getMessage()));
    	}
    }
}
