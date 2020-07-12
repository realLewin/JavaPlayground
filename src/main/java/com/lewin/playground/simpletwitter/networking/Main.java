package com.lewin.playground.simpletwitter.networking;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args){
        try{
            HttpServer server = HttpServer.create(new InetSocketAddress(7777), 0);
            server.createContext("/api", new MainHandler());
            server.setExecutor(null);
            server.start();
        }catch(IOException e){
            System.out.println("error: " + e.getMessage());
        }
    }
}
