package com.lewin.playground.javacourse.networking.udpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class MainClient {
  public static void main(String[] args) {
    try {
      InetAddress address = InetAddress.getLocalHost();
      DatagramSocket socket = new DatagramSocket();
      Scanner scanner = new Scanner(System.in);
      String sendData;

      do {
        System.out.println("enter your data to send: ");
        sendData = scanner.nextLine();
        byte[] buffer = sendData.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
        socket.send(packet);

        byte[] receiveBuffer = new byte[50];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
        socket.receive(receivePacket);
        System.out.println("Server echo: " + new String(receiveBuffer));

      } while (!sendData.equals("exit"));

    } catch (SocketException e) {
      System.out.println("socket error" + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO error" + e.getMessage());
    }
  }
}
