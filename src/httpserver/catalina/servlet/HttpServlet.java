package httpserver.catalina.servlet;

import httpserver.catalina.executor.HttpRequest;
import httpserver.catalina.executor.HttpResponse;
import java.io.IOException;

/**
 * java 의 공식 HttpServlet 인터페이스를 구현한 WAS의 대표적인 예시로 Tomcat이 있는 것 WAS 들이 Servlet interface에 맞춰 구현을 했기
 * 때문에 WAS의 스펙을 손쉽게 바꿀 수 있음.
 */
public interface HttpServlet {

    void service(HttpRequest request, HttpResponse response) throws IOException;

}
