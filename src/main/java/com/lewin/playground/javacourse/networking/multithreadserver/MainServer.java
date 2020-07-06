package com.lewin.playground.javacourse.networking.multithreadserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
  public static void main(String[] args) {
    try(ServerSocket serverSocket = new ServerSocket(5000)){
      while (true){
        new Echoer(serverSocket.accept()).start();
        //the above line is equal to:
        //Socket socket = serverSocket.accept();
        //Echoer echoer = new Echoer(socket);
        //echoer.start();
      }
    }catch(IOException e){
      System.out.println("error: " + e.getMessage());
    }
  }
}
