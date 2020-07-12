package com.lewin.playground.simpletwitter.networking;

import com.google.gson.Gson;
import com.lewin.playground.simpletwitter.models.Post;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class MainHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream is = exchange.getRequestBody();
        readData(is);
        Gson gson = new Gson();
        String response = gson.toJson("I am here");

        Headers headers = exchange.getResponseHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Method", "GET, POST, PUT, DELETE, PATCH");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization");

        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private static void readData(InputStream is) {
//        Post post = new Post("default", "default");
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder builder = new StringBuilder();
            String receivedData;
            while ((receivedData = reader.readLine()) != null) {
                builder.append(receivedData);
            }
            Gson gson = new Gson();
            Post post = gson.fromJson(builder.toString(), Post.class);
            System.out.println(post);

        } catch (UnsupportedEncodingException e) {
            System.out.println("encoding error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }
    }
}
