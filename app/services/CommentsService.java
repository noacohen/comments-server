package services;

import java.net.URL;
import java.util.HashSet;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Comment;

public class CommentsService {
	public static HashSet<Comment> comments;
	
	public static HashSet<Comment> getCommentsByPostId(int postId) {
		return comments.stream().filter(comment -> comment.postId == postId)
								.collect(Collectors.toCollection(HashSet::new));
	}
	
	public static void initializeComments() {
		String commentsURL = "";
		
		try {
			commentsURL = PropertiesService.getProperties().getProperty("commentsURL");
			comments = new ObjectMapper().readValue(new URL(commentsURL), 
										new TypeReference<HashSet<Comment>>() { } );
		} catch(Exception e) {
			System.out.println(String.format("Error initializing comments from URL: %s. Error: %s", commentsURL, e.getMessage()));
		}
	}
}