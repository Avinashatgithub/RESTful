package edu.aarav.jersey.messanger.ext;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import edu.aarav.jersey.messanger.domain.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage(404, "Data Not Found", "https://javabrains.io/courses/javaee_jaxrs");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}
}
