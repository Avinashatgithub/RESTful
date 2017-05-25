package edu.aarav.jersey.messanger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/path-segment")
@Consumes({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
public class PathSegmentResourceExample {
	
	public String getSegments(String path1){
		return null;
	}
}
