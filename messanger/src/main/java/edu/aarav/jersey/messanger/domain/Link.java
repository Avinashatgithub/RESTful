package edu.aarav.jersey.messanger.domain;

public class Link {
	private String rel;
	private String uri;

	public Link() {
		super();
	}

	public Link(String rel, String uri) {
		super();
		this.rel = rel;
		this.uri = uri;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getLink() {
		return uri;
	}

	public void setLink(String uri) {
		this.uri = uri;
	}

}
