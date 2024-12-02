package httpserver.catalina.servlet;

import httpserver.catalina.executor.HttpRequest;
import httpserver.catalina.executor.HttpResponse;

public class DiscardServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        // empty
    }

}
