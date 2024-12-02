package httpserver.catalina.servlet;

import httpserver.catalina.executor.HttpRequest;
import httpserver.catalina.executor.HttpResponse;

public class NotFoundServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.setStatusCode(404);
        response.writeBody("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>404 - 페이지를 찾을 수 없습니다</title>
                    <style>
                        body {
                            margin: 0;
                            font-family: 'Arial', sans-serif;
                            background-color: #f4f4f9;
                            color: #333;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            height: 100vh;
                            text-align: center;
                        }
                        .container {
                            max-width: 600px;
                            padding: 20px;
                            background: #fff;
                            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
                            border-radius: 8px;
                        }
                        h1 {
                            font-size: 2.5rem;
                            color: #ff4b5c;
                            margin-bottom: 20px;
                        }
                        p {
                            font-size: 1.2rem;
                            margin-bottom: 20px;
                        }
                        a {
                            display: inline-block;
                            padding: 10px 20px;
                            font-size: 1rem;
                            text-decoration: none;
                            color: #fff;
                            background-color: #007bff;
                            border-radius: 5px;
                            transition: background-color 0.3s ease;
                        }
                        a:hover {
                            background-color: #0056b3;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h1>404 - 페이지를 찾을 수 없습니다</h1>
                        <p>죄송합니다. 요청하신 페이지가 존재하지 않습니다.</p>
                        <a href="/">홈으로 돌아가기</a>
                    </div>
                </body>
                </html>
                """
        );


    }

}
