package example.servlet;

import httpserver.catalina.executor.HttpRequest;
import httpserver.catalina.executor.HttpResponse;
import httpserver.catalina.servlet.HttpServlet;

public class Site2Servlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>site2</h1>");
    }

}
