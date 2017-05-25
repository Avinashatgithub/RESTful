package edu.aarav.jersey.messanger.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message", propOrder = { "id", "message", "author", "created", "comments" })
public class Message {
	private long id;
	private String message;
	private Date created;
	private String author;
	
	private Map<Long, Comment> comments = new HashMap<>();

	public Message() {
		super();
	}

	public Message(long id, String message, Date created, String author) {
		super();
		this.id = id;
		this.message = message;
		this.created = created;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}
	
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment){
		comments.put(comment.getId(), comment);
	}

}
