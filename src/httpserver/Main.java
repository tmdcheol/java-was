package httpserver;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        HttpServerConfig config = new HttpServerConfig();
        config.httpServer()
                .start();
    }

}
