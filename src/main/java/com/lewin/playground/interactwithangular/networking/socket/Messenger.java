package com.lewin.playground.interactwithangular.networking.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Messenger extends Thread {
    private Socket socket;
    private String[] myMes = {"hello", "I'm lewin", "bye"};

    public Messenger(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try{
            System.out.println("server connected");
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(),true);
            String receiveData;
            do{
                receiveData = serverInput.readLine();
                System.out.println(receiveData);
                serverOutput.println("there");
            }while(!receiveData.equals("exit"));
        }catch(IOException e){
            System.out.println("error" + e.getMessage());
        }finally{
            try{
                socket.close();
                System.out.println("server closed");
            }catch(IOException e){
                System.out.println("socket close error" + e.getMessage());
            }
        }
    }
}
