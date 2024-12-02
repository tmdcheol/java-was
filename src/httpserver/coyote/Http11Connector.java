package httpserver.coyote;

import static logger.CustomLogger.log;

import httpserver.catalina.executor.HttpExecutor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Http11Connector {

    private final int port;
    private final HttpExecutor executor;

    public Http11Connector(
            final int port,
            final HttpExecutor executor
    ) {
        this.port = port;
        this.executor = executor;
    }

    // main thread 에서 실행
    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) { // client 요청을 받기 위한 socket
            log("서버 시작 PORT: " + port);

            while (true) {
                Socket socket = serverSocket.accept(); // client 통신하기 위한 socket
                executor.run(socket);
            }
        }
    }
}
