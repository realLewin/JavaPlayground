package com.lewin.playground.javacourse.networking.simpledemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
  public static void main(String[] args) {
    try(ServerSocket serverSocket = new ServerSocket(5000)){
      Socket socket = serverSocket.accept();
      System.out.println("connect established");

      BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(),true);

      while(true){
        String receivedData = serverInput.readLine();
        if(!receivedData.equals("exit")){
          serverOutput.println("echo from server: " + receivedData);
        }else {
          break;
        }
      }

    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
