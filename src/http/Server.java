package http;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;


public class Server {
    private static String query = "";
    public final static String SOCKET_PORT = "8081";
//    private HttpServer server;

    public Server() {
//        this.start();
    }

    public static void start() {
        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(8081), 0);
            server.createContext("/",
                    new HttpHandler() {
                        @Override
                        public void handle(HttpExchange exchange) throws IOException {
                            String codeReceived = "Got the code. Return back to your program.";
                            String codeNotFound = "Authorization code not found. Try again.";
                            query = exchange.getRequestURI().getQuery();
                            if (query == null) {
                                System.out.println("no code");
                                exchange.sendResponseHeaders(200, codeNotFound.length());
                                exchange.getResponseBody().write(codeNotFound.getBytes());
                                query = "";
                            } else {
                                System.out.println("code received");
                                System.out.println(query);
                                exchange.sendResponseHeaders(200, codeReceived.length());
                                exchange.getResponseBody().write(codeReceived.getBytes());
                            }
                            exchange.getResponseBody().close();
//                            System.out.println(query);
                        }
                    });
            server.start();
//            server.stop(100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void stopServer() {
    }

    public static String getCode() {
        String[] code = query.split("=");
        if (code.length == 2) {
            return code[1];
        }
        return null;
    }
}
