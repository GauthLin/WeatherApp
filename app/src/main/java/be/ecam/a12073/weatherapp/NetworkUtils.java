package be.ecam.a12073.weatherapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class NetworkUtils {
    public static String getResponseFromHttpUrl(String url) throws IOException {
        URL urlObject = new URL(url);

        HttpsURLConnection urlConnection = (HttpsURLConnection) urlObject.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput)
                return scanner.next();
            else
                return null;
        } finally {
            urlConnection.disconnect();
        }
    }

}
