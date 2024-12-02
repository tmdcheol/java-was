package httpserver.catalina.container;

import example.servlet.HomeServlet;
import example.servlet.SearchServlet;
import example.servlet.Site1Servlet;
import example.servlet.Site2Servlet;
import httpserver.catalina.servlet.DiscardServlet;

public class ServletContainerConfig {

    /**
     * 호출할 때마다 서블릿이 서블릿 컨테이너에 추가되는 구조임
     * 개선 필요
     */
    public ServletContainer servletContainer() {
        ServletContainer container = ServletContainer.getInstance();

        // custom
        container.add("/", homeServlet());
        container.add("/site1", site1Servlet());
        container.add("/site2", site2Servlet());
        container.add("/search", searchServlet());
        container.add("/favicon.ico", discardServlet());

        return container;
    }

    /**
     * 싱글톤으로 관리되어야 하는 객체들이지만, 싱글톤이 아님
     * 개선 필요
     */
    public HomeServlet homeServlet() {
        return new HomeServlet();
    }

    public Site1Servlet site1Servlet() {
        return new Site1Servlet();
    }

    public Site2Servlet site2Servlet() {
        return new Site2Servlet();
    }

    public SearchServlet searchServlet() {
        return new SearchServlet();
    }

    public DiscardServlet discardServlet() {
        return new DiscardServlet();
    }

}
