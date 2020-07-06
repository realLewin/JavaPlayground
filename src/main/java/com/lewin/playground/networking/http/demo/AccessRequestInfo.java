package com.lewin.playground.networking.http.demo;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpPrincipal;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class AccessRequestInfo implements HttpHandler {
  @Override
  public void handle(HttpExchange exchange) throws IOException{
    URI requestUri = exchange.getRequestURI();
    printRequestInfo(exchange);
    String response = "The response from server: " + requestUri;
    exchange.sendResponseHeaders(200, response.length());
    OutputStream os = exchange.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }

  private void printRequestInfo(HttpExchange exchange){
    System.out.println("---- Header ----");
    Headers headers = exchange.getRequestHeaders();
    headers.entrySet().forEach(System.out::println);

    System.out.println("---- Principle ----");
    HttpPrincipal principal = exchange.getPrincipal();
    System.out.println(principal);

    System.out.println("---- HTTP Method----");
    String method = exchange.getRequestMethod();
    System.out.println(method);

    System.out.println("---- Query ----");
    URI uri = exchange.getRequestURI();
    String query = uri.getQuery();
    System.out.println(query);
  }

}












