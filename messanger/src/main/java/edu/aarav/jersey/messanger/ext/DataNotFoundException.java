package edu.aarav.jersey.messanger.ext;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7464509856623297457L;

	public DataNotFoundException() {
		super();
	}

	public DataNotFoundException(String message) {
		super(message);
	}
	

}
