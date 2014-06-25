package org.ttang;

import org.ttang.jersey.GuiceConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.google.inject.servlet.GuiceFilter;

public class Main {
	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);
		ServletContextHandler sch = new ServletContextHandler(server, "/");

		// static content
		sch.addServlet(DefaultServlet.class,"/").setInitParameter("resourceBase", "webapps");
		
		// Guice servlets
		sch.addFilter(GuiceFilter.class, "/services/*", null);
		sch.addEventListener(new GuiceConfig());
		
		server.start();
		server.join();
	}
}
