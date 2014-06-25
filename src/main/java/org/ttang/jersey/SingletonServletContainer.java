package org.ttang.jersey;

import com.google.inject.Singleton;
import com.sun.jersey.spi.container.servlet.ServletContainer;

@SuppressWarnings("serial")
@Singleton
public class SingletonServletContainer extends ServletContainer {
}
