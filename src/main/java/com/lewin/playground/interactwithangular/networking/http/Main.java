package com.lewin.playground.interactwithangular.networking.http;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(7777),0);
        server.createContext("/",new MyHandler());
        server.setExecutor(null);
        server.start();
    }
}
