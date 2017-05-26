package edu.aarav.jersey.messanger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import edu.aarav.jersey.messanger.domain.Message;
import edu.aarav.jersey.messanger.resources.bean.MessageFilterBean;
import edu.aarav.jersey.messanger.service.MessageService;

@Path("/messages")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML })
public class MessageResource {

	private MessageService messageService = new MessageService();

	// url = "/messanger/webapi/messages"
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}

		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}

		return messageService.getAllMessages();
	}

	// url = "/messanger/webapi/messages/{msgId}
	@Path("/{messageId}")
	@GET
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(id);
		message.addLinks("self", getUriForSelf(uriInfo, message));
		message.addLinks("profile", getUriForProfile(uriInfo, message));
		message.addLinks("comment", getUriForComment(uriInfo, message));
		return message;
	}

	// helper method to create and return link to the comments of this message that will be
	// link:  /messanger/webapi/messages/{messageId}/comments
	private String getUriForComment(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId", message.getId())
				.toString(); 
		return uri;
	}

	// helper method to get extract URI for self
	// link:  /messanger/webapi/messages/{messageId}
	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(Long.toString(message.getId()))
				.toString();
		return uri;
	}

	// helper method to get extract URI for Profile of the Message Author
	// link:  /messanger/webapi/profiles/{profileName}
	private String getUriForProfile(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(ProfileResource.class)
				.path(message.getAuthor())
				.toString();
		return uri;
	}

	// url = "/messanger/webapi/messages"
	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}

	// url = "/messanger/webapi/messages/{msgId}"
	@Path("/{messageId}")
	@PUT
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	// url = "/messanger/webapi/messages/{msgId}"
	@Path("/{messageId}")
	@DELETE
	public Message deleteMessage(@PathParam("messageId") long id) {
		return messageService.removeMessage(id);
	}

	// Sub-resource delegate method for CommentResource
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}