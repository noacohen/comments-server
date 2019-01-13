package services;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.*;

import models.Comment;

import helpers.Helper;

public class CommentServiceTest {
	private HashSet<Comment> comments;
	//private CommentsService service = new CommentsService();
	
	@Before
	public void initEveryTest() {
		CommentsService.comments = Helper.getComments();
	}
	
	@Test
	public void testGetCommentsByPostId_PostIdExists() {
		comments = CommentsService.getCommentsByPostId(1);
		assertEquals(comments.size(), 1);
	}
	
	@Test
	public void testGetCommentsByPostId_PostIdNotExists() {
		comments = CommentsService.getCommentsByPostId(3);
		assertEquals(comments.size(), 0);
	}
	
	
}
