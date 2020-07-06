package com.lewin.playground.javacourse.networking.udpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MainServer {
  public static void main(String[] args) {
    try{
      DatagramSocket socket = new DatagramSocket(5000);

      while(true){
        byte[] buffer = new byte[50];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        System.out.println("get data from client: " + new String(buffer, 0, buffer.length));

        InetAddress address = InetAddress.getLocalHost();
        int port = packet.getPort();
        DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length,address,port);
        socket.send(sendPacket);
      }

    }catch(SocketException e){
      System.out.println("socket error: " + e.getMessage());
    }catch(IOException e){
      System.out.println("IO error: " + e.getMessage());
    }
  }
}
