package com.lewin.playground.networking.http.demo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HelloWorld implements HttpHandler {
  @Override
  public void handle(HttpExchange e) throws IOException{
    InputStream is = e.getRequestBody();
//    read(is);//read the request body;
    String response = "hello world!";
    e.sendResponseHeaders(200, response.getBytes().length);
    OutputStream os = e.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }
}

/**
 * this is another implementation of the hello world program;
 */
//  public static void main(String[] args) throws IOException {
//    HttpServer server = HttpServer.create(new InetSocketAddress(4200), 0);
//    HttpContext context = server.createContext("/");
//    context.setHandler(Main::handleRequest);
//    server.start();
//  }
//
//  private static void handleRequest(HttpExchange exchange) throws IOException {
//    String response = "hello world!";
//    exchange.sendResponseHeaders(200, response.getBytes().length);//response code and length
//    OutputStream os = exchange.getResponseBody();
//    os.write(response.getBytes());
//    os.close();
//  }

