package edu.aarav.jersey.messanger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

@Path("/inject")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectionDemoResource {
	
	// http://localhost:8000/messanger/webapi/inject/{Avinash Kumar;desig=Software Engineer;exp=2}
	@Path("/{employee}")
	@GET
	public String matrixParamTest(@PathParam("employee") String employee,
									@MatrixParam("desig") String desig, @MatrixParam("exp") int exp){
		return "Employee Name: "+employee+"\nDesignation: "+desig+"\nExperience: "+exp+" yrs";
	}
	
	// this method will execute only if parameter value matches the regular expression defined.
	// http://localhost:8000/messanger/webapi/inject/{Avinash}
	@GET
	@Path("/{param:[a-zA-Z][a-zA-Z_0-9]*}")
	public String regexTest(@PathParam("param")String param){
		return "Result: "+param;
	}
	
	@GET
	@Path("/test/seg/{id}/{id2}")
	public String pathSegmentExp(@PathParam("id") PathSegment id,@PathParam("id2") PathSegment id2){
		MultivaluedMap<String,String> parameters = id.getMatrixParameters();
		
		return id.toString()+" : "+parameters.toString()+"\n"+id2.toString()+" : "+id2.getMatrixParameters();
	}
	
	@GET
	@Path("/header")
	public String headerParamTest(@HeaderParam("value") String value){
		return value;
	}
	
}
