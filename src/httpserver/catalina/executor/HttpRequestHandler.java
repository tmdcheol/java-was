package httpserver.catalina.executor;

import static logger.CustomLogger.log;

import httpserver.catalina.container.ServletContainer;
import httpserver.catalina.servlet.HttpServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpRequestHandler implements Runnable {

    private final Socket socket;
    private final ServletContainer servletContainer;

    public HttpRequestHandler(Socket socket, ServletContainer container) {
        this.socket = socket;
        this.servletContainer = container;
    }

    // worker thread 실행부
    @Override
    public void run() {
        try {
            process();
        } catch (Exception e) {
            log(e);
        }
    }

    private void process() throws IOException {

        HttpRequest request = null;
        HttpResponse response = null;

        // try-with-resource
        try (socket;
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter writer = new PrintWriter(
                        socket.getOutputStream(), false, StandardCharsets.UTF_8)) {

            request = new HttpRequest(reader);
            response = new HttpResponse(writer);

            log("HTTP 요청 메시지:" + request);

            /**
             * 실행부
             */
            HttpServlet httpServlet = servletContainer.getServlet(request, response);
            httpServlet.service(request, response);
            response.flush();

            log("HTTP 응답 메시지:" + response);
        } catch (Exception e) {
            log("서버 내부 에러 발생:" + e);
            servletContainer.getInternalErrorServlet()
                    .service(request, response);
            response.flush();
        }
    }
}
