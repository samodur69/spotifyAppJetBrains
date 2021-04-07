package http;

public class Authenticator {
    private String authResponse = "";
    private String authCode = "";

    public static void launchServer() {

    }

    /**
     * Token create string.
     *  OAuth 2.0
     * @return string with token to authorize on Spotify server
     */
    public static String tokenCreate() {
        return new StringBuilder()
                .append("https://accounts.spotify.com/authorize")
                .append("?client_id=")
                .append(Properties.getClientID())
                .append("&redirect_uri=")
                .append(Properties.getRedirect_url())
                .append("&response_type=code").toString();
    }
}
