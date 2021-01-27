package http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.*;
import com.sun.net.httpserver.*;


public class Server {
    //HttpServer server = null;
    // написать конструктор в котором при создании объекта сервер запускается сервер
    // пока запуск статическим методом

    public static void start() {
        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(8081), 0);
            server.createContext("/",
                    new HttpHandler() {
                        @Override
                        public void handle(HttpExchange httpExchange) throws IOException {
                            String hello = "hello, world";
                            httpExchange.sendResponseHeaders(200, hello.length());
                            httpExchange.getResponseBody().write(hello.getBytes());
                            httpExchange.getResponseBody().close();
                        }
                    });
            server.start();
        } catch (IOException e) {
            System.out.println("Troubles with start server at .......");
            e.printStackTrace();
        }
    }

    public static void stopServer () {

    }
}
