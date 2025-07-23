package GAPI;

import java.io.*;
import java.net.*;

public class Gemini {
    public static void main(String[] args) throws Exception {
        String apiKey = "AIzaSyC-QcAuo36Iq8xcLbEFSm0ekJZAPR3d5qs";
        String urlStr = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + apiKey;

        // Predefined question (can be changed anytime)
        String prompt = "Tell me a short story about a brave girl who saved her village.";

        // JSON body for the API request
        String json = "{\"contents\":[{\"parts\":[{\"text\":\"" + prompt + "\"}]}]}";

        // Setup HTTP POST request
        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        // Send request body
        try (OutputStream os = con.getOutputStream()) {
            os.write(json.getBytes());
        }

        // Read the response
        try (
                InputStream inputStream = con.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(inputStreamReader)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
