package services;

import java.net.URL;
import java.util.HashSet;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Models.Comment;

public class CommentsService {
	public static HashSet<Comment> comments;
	
	public static HashSet<Comment> getCommentsByPostId(int postId) {
		return comments.stream().filter(comment -> comment.postId == postId)
								.collect(Collectors.toCollection(HashSet::new));
	}
	
	public static void initializeComments() {
		try {
			comments = new ObjectMapper().readValue(new URL("https://jsonplaceholder.typicode.com/comments"), 
										new TypeReference<HashSet<Comment>>() { } );
		} catch(Exception e) {
			
		}
	}
}