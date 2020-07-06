package com.lewin.playground.networking.http.demo;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
  public static void main(String[] args) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(4200),0);
    server.createContext("/", new AccessRequestInfo());
    server.setExecutor(null);
    server.start();
  }
}
