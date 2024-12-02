package httpserver.catalina.servlet;

import httpserver.catalina.executor.HttpRequest;
import httpserver.catalina.executor.HttpResponse;

public class InternalErrorServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.setStatusCode(404);
        response.writeBody("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>404 - Page Not Found</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            text-align: center;
                            color: #333;
                            margin: 0;
                            padding: 0;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            height: 100vh;
                            background-color: #f7f7f7;
                        }
                        .container {
                            max-width: 600px;
                            padding: 20px;
                            border-radius: 10px;
                            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                            background: white;
                        }
                        h1 {
                            font-size: 2.5rem;
                            color: #ff6b6b;
                        }
                        p {
                            font-size: 1.2rem;
                        }
                        a {
                            color: #007bff;
                            text-decoration: none;
                        }
                        a:hover {
                            text-decoration: underline;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h1>404 - Page Not Found</h1>
                        <p>Sorry, the page you're looking for doesn't exist.</p>
                        <p><a href="/">Return to Home</a></p>
                    </div>
                </body>
                </html>
                """
        );

    }
}
