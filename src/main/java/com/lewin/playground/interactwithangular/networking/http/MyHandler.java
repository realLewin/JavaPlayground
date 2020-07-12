package com.lewin.playground.interactwithangular.networking.http;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Headers headers = exchange.getResponseHeaders();
        headers.add("Access-Control-Allow-Origin","*");
        headers.add("Access-Control-Method","GET, POST, PUT, DELETE, PATCH");
        headers.add("Access-Control-Allow-Headers","Content-Type, Authorization");

        InputStream is = exchange.getRequestBody();
//        String response = "hello angular from java!";
        Gson g = new Gson();
        String response = g.toJson("hello from java");
        exchange.sendResponseHeaders(200,response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
