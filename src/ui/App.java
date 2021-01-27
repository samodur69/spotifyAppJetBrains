package ui;

import http.Client;
import oauth.SpotifyOAuth;
import responses.Featured;
import responses.Releases;

import java.util.Scanner;

public class App {
    private static boolean logged;

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        logged = false;
        while (true) {
            System.out.println("wait for input:");
            String input = scanner.nextLine();
            String[] processInput = input.split(" ");
            if (logged) {
                switch (processInput[0]) {
                    case "new":
                        System.out.println("---NEW RELEASES---");
                        Releases.printReleases();
                        break;
                    case "test":
                        Client.requestGet();
                        break;
                    case "featured":
                        System.out.println("---FEATURED---");
                        Featured.printFeatured();
                        break;
                    case "categories":
                        System.out.println("---CATEGORIES---");
                        break;
                    case "playlists":
                        String playlistGenre = processInput[1];
                        System.out.println("---" + playlistGenre + " PLAYLISTS---");
                        break;
//                    case "auth":
//                        String authUrl = scanner.nextLine();
//                        break;
                    case "exit":
                        System.out.println("---GOODBYE!---");
                        System.exit(0);
                }
            } else if (!logged && "auth".equals(processInput[0])) {
                System.out.println(SpotifyOAuth.tokenCreate());
                System.out.println("---SUCCESS---");
                logged = true;
            } else if (!logged && "exit".equals(processInput[0])) {
                System.out.println("---GOODBYE!---");
                System.exit(0);
            } else {
                System.out.println("Please, provide access for application.");
            }
        }
    }
}
