package com.lewin.playground.javacourse.networking.multithreadserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
  private Socket socket;

  public Echoer(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try{
      BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      //always set autoFlush to true when using this demo;
      PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);
      System.out.println("server start listening...");
      while(true){
        String receivedData = serverInput.readLine();
        if(receivedData.equals("exit")){
          break;
        }
        try{
          Thread.sleep(10000);
        }catch(InterruptedException e){
          System.out.println("interrupted.");
        }
        serverOutput.println(receivedData);
      }
    }catch(IOException e){
      System.out.println("IO error: " + e.getMessage());
    }finally{
      try{
        socket.close();
      }catch(IOException e){
        System.out.println("socket close error" + e.getMessage());
      }
    }
  }
}
