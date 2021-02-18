package fr.epsi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connection {
    public static String getJSONObject(String path){
        String result = "";
        try {
            URL url = new URL(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = "";
            while (null != (str = br.readLine())) {
                result += str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
        
    }
}
