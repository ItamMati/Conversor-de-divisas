package com.alura.conversordemonedas.Api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class ApiConversor {


    // Setting URL
    String url_str = "https://v6.exchangerate-api.com/v6/5b31f401b0da815f895eaea3/latest/USD";

    // Making Request
    URL url;

    HttpURLConnection request;



    public HttpURLConnection requestApi() throws IOException {
        try {
            url = new URL(url_str);
            request = (HttpURLConnection) url.openConnection();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       return request;

    }

    public  Object convertirAJson() throws IOException {

        // Convert to JSON
        JsonParser jp = new JsonParser();

        JsonElement root = jp.parse(new InputStreamReader((InputStream) this.requestApi().getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing

        Object req_result = jsonobj.get("conversion_rates").getAsJsonObject();

        return req_result;
    }
}
