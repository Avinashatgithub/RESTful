package edu.aarav.jersey.messanger.ext;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import edu.aarav.jersey.messanger.domain.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {

		return Response.status(Status.NOT_FOUND)
				.entity(new ErrorMessage(404, "Requested resource not found.", "http://google.com"))
				.build();
	}
}