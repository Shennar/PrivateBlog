package privateblog.authentification;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class BasicAuthentification {
    public static boolean checkAutentification(String urlAddress, String username, String password) {
        boolean authentificationResult = false;
        try {
            URL url = new URL(urlAddress);
            String credentials = username + ":" + password;
            String authEncoded = Base64.getEncoder().encodeToString((credentials).getBytes());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + authEncoded);
            if (connection.getResponseCode()==200) authentificationResult = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return authentificationResult;
    }
}
