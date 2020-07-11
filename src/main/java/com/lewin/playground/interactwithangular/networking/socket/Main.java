package com.lewin.playground.interactwithangular.networking.socket;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try(ServerSocket socket = new ServerSocket(7777)){
            while(true){
                new Messenger(socket.accept()).start();
            }
        }catch(IOException e){
            System.out.println("error" + e.getMessage());
        }
    }
}
