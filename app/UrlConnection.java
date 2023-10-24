import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnection {
    public void UrlConnection() throws IOException {

        HttpURLConnection urlConnection;

        String url = "https://cataas.com/cat?json=true";
        urlConnection = (HttpURLConnection) new URL(url).openConnection();
        urlConnection.setDoInput(true);
        urlConnection.connect();
        inputS = urlConnection.getInputStream();
    }
}