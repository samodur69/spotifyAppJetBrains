package http;

public class Properties {
    private static final String SOCKET_PORT = "8081";
    private static final String redirect_url = "http://localhost:" + Properties.SOCKET_PORT;
    private final static String clientID = "602b13b0f75e4ef989e7504dcff95673";
    public static final String ACCESS_DENIED = "Please, provide access for application";

    public static String getSocketPort() {
        return SOCKET_PORT;
    }

    public static String getRedirect_url() {
        return redirect_url;
    }

    public static String getClientID() {
        return clientID;
    }
}
