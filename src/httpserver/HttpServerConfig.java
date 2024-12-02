package httpserver;

import httpserver.catalina.container.ServletContainer;
import httpserver.catalina.container.ServletContainerConfig;
import httpserver.coyote.Http11Connector;
import httpserver.catalina.executor.HttpExecutor;

public class HttpServerConfig {

    private static final int PORT = 8080;
    private static final int THREAD_COUNT = 200;

    public HttpServer httpServer() {
        return new HttpServer(http11Connector());
    }

    private Http11Connector http11Connector() {
        return new Http11Connector(PORT, httpExecutor());
    }

    private HttpExecutor httpExecutor() {
        return new HttpExecutor(THREAD_COUNT, servletContainer());
    }

    private ServletContainer servletContainer() {
        ServletContainerConfig config = new ServletContainerConfig();
        return config.servletContainer();
    }

}
