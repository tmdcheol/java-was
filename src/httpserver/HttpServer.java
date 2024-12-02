package httpserver;

import httpserver.coyote.Http11Connector;
import java.io.IOException;

public class HttpServer {

    private final Http11Connector http11Connector;

    public HttpServer(final Http11Connector http11Connector) {
        this.http11Connector = http11Connector;
    }

    public void start() throws IOException {
        http11Connector.start();
    }

}
