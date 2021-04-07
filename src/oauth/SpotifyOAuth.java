package oauth;

import http.Server;

public class SpotifyOAuth {
    private final static String clientID = "602b13b0f75e4ef989e7504dcff95673";
    private static final String redirect_url = "http://localhost:" + Server.SOCKET_PORT;

    /**
     * Token create string.
     *  OAuth 2.0
     * @return string with token to authorize on Spotify server
     */
    public static String tokenCreate() {
        return new StringBuilder()
                .append("https://accounts.spotify.com/authorize")
                .append("?client_id=")
                .append(clientID)
                .append("&redirect_uri=")
                .append(redirect_url)
                .append("&response_type=code")
                .toString();
    }

    public static String postBody() {
      StringBuilder post = new StringBuilder();
      post.append("grant_type=authorization_code&code=")
              .append(Server.getCode())
              .append("&")
              .append(redirect_url);
      return post.toString();
    }



}
