package services;

import java.net.URL;
import java.util.HashSet;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import models.Comment;

/**
 * This service holds all comments and handle them
 */
public class CommentsService {
	public static HashSet<Comment> comments;
	
	public static HashSet<Comment> getCommentsByPostId(int postId) {
		return comments.stream().filter(comment -> comment.postId == postId)
								.collect(Collectors.toCollection(HashSet::new));
	}
	
	public static void initializeComments() {
		String commentsURL = "";
		
		try {
			ObjectMapper mapper = new ObjectMapper()
					.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
                    .configure(SerializationFeature.INDENT_OUTPUT, true)
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
                    .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false)
                    .configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, true)
                    .configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true)
                    .configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
			
			commentsURL = PropertiesService.getProperties().getProperty("commentsURL");
			comments = mapper.readValue(new URL(commentsURL), 
										new TypeReference<HashSet<Comment>>() { } );
		} catch(Exception e) {
			System.out.println(String.format("Error initializing comments from URL: %s. Error: %s", commentsURL, e.getMessage()));
		}
	}
}