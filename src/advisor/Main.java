package advisor;

import http.Server;
import ui.App;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server.start();
        App.start();
    }
}
