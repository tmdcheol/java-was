package httpserver.catalina.executor;

import httpserver.catalina.container.ServletContainer;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpExecutor {

    private final ExecutorService threadPool;
    private final ServletContainer container;

    public HttpExecutor(
            final int threadsCount,
            final ServletContainer container
    ) {
        this.threadPool = Executors.newFixedThreadPool(threadsCount);  // threadPool, 스레드 개수 고정 방식
        this.container = container;
    }

    public void run(Socket socket) {
        threadPool.submit(new HttpRequestHandler(socket, container));
    }

}
