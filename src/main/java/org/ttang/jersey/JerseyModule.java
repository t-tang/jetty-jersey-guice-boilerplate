package org.ttang.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.ttang.MyClass;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/hello")
public class JerseyModule {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello() {
		return Response.ok(new MyClass()).build();
	}
}