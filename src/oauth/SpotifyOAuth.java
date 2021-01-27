package oauth;

public class SpotifyOAuth {
    private final static String clientID = "602b13b0f75e4ef989e7504dcff95673";
    private final static String clientSecret = "a4a125c41835452e8d2d0494046df555";
    private static String access_token;
    private static String redirect_url = "https://www.example.com";

    public static String tokenCreate() {
        StringBuilder token = new StringBuilder("https://accounts.spotify.com/authorize");
        token.append("?client_id=");
        token.append(clientID);
        token.append("&redirect_uri=");
        token.append(redirect_url);
        token.append("&response_type=code");
        return token.toString();
    }

    public static String getClientID() {
        return clientID;
    }

    public static String getClientSecret() {
        return clientSecret;
    }
}
