package edu.aarav.jersey.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.aarav.jersey.messanger.domain.Comment;
import edu.aarav.jersey.messanger.service.CommentService;

@Path("/")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class CommentResource {

	private CommentService service = new CommentService();

	// uri = /messsanger/webapi/messages/{messageId}/comments
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return service.getAllComments(messageId);
	}

	// uri = /messsanger/webapi/messages/{messageId}/comments/{commentId}
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") String commentId) {
		return service.getComment(messageId, commentId);
	}

	// uri = /messsanger/webapi/messages/{messageId}/comments
	@POST
	public Comment makeComment(@PathParam("messageId") long messageId, Comment comment) {
		return service.makeComment(messageId, comment);
	}

	// uri = /messsanger/webapi/messages/{messageId}/comments/{commentId}
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId,
			Comment comment) {
		comment.setId(commentId);
		return service.updateComment(messageId, comment);
	}

	// uri = /messsanger/webapi/messages/{messageId}/comments/{commentId}
	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return service.deleteComment(messageId, commentId);
	}
}