package httpserver.catalina.container;

import static logger.CustomLogger.log;

import httpserver.catalina.executor.HttpRequest;
import httpserver.catalina.executor.HttpResponse;
import httpserver.catalina.servlet.HttpServlet;
import httpserver.catalina.servlet.InternalErrorServlet;
import httpserver.catalina.servlet.NotFoundServlet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServletContainer {

    private static final ServletContainer INSTANCE = new ServletContainer(); // 싱글톤 패턴

    // custom servlets, 동시성 고려하여 ConcurrentHashMap
    private final Map<String, HttpServlet> servletMap = new ConcurrentHashMap<>();

    private final HttpServlet notFoundErrorServlet = new NotFoundServlet(); // not found 때
    private final HttpServlet internalErrorServlet = new InternalErrorServlet(); // interval server error

    private ServletContainer() {
    }

    public static ServletContainer getInstance() {
        return INSTANCE;
    }

    public void add(String path, HttpServlet servlet) {
        servletMap.put(path, servlet);
    }

    public HttpServlet getServlet(HttpRequest request, HttpResponse response) {
        HttpServlet servlet = servletMap.get(request.getPath());
        if (servlet == null) {
            log("not found url: " + request.getPath());
            return notFoundErrorServlet;
        }
        return servlet;
    }

    public HttpServlet getInternalErrorServlet(){
        return internalErrorServlet;
    }

}
