package edu.aarav.jersey.messanger.ext;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import edu.aarav.jersey.messanger.domain.ErrorMessage;

@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {

		return Response.status(Status.BAD_REQUEST)
				.entity(new ErrorMessage(400, "No Resource found with this Request", "http://google.com")).build();
	}

}
