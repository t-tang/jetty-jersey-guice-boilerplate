package org.ttang.jersey;

import java.util.HashMap;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.guice.JerseyServletModule;

public class GuiceConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new JerseyServletModule() {
			@Override
			protected void configureServlets() {
				bind(SingletonServletContainer.class);
			    serve("/services/*").with(SingletonServletContainer.class, new HashMap<String, String>(){
			        {
			            put(PackagesResourceConfig.PROPERTY_PACKAGES, SingletonServletContainer.class.getPackage().getName());
			            put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE.toString());
			        }
			    });
			}
		});
	}
}