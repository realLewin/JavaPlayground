package com.lewin.playground.javacourse.networking.simpledemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {

  public static void main(String[] args) {
    try(Socket socket = new Socket("localhost", 5000)){
      BufferedReader clientInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter clientOutput = new PrintWriter(socket.getOutputStream(),true);
      Scanner scanner = new Scanner(System.in);
      String sendData;
      String response;

      do{
        System.out.println("input your data: ");
        sendData = scanner.nextLine();
        clientOutput.println(sendData);
        if(!sendData.equals("exit")){
          response = clientInput.readLine();
          System.out.println(response);
        }
      }while(!sendData.equals("exit"));

    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
