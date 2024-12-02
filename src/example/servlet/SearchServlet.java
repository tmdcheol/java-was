package example.servlet;

import httpserver.catalina.executor.HttpRequest;
import httpserver.catalina.executor.HttpResponse;
import httpserver.catalina.servlet.HttpServlet;

public class SearchServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        String query = request.getParameter("q")
                .orElseThrow(IllegalArgumentException::new);
        response.writeBody("<h1>Search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }

}
