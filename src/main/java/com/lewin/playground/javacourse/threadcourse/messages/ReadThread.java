package com.lewin.playground.javacourse.threadcourse.messages;

import java.util.Random;

public class ReadThread implements Runnable {
  private Message message;

  public ReadThread(Message message) {
    this.message = message;
  }

  @Override
  public void run() {
    Random random = new Random();
    for (String currentMes = message.readMes(); currentMes != "finished"; currentMes = message.readMes()) {
      System.out.println(currentMes);
      try{
        Thread.sleep(random.nextInt(2000));
      }catch(InterruptedException e){

      }
    }
  }
}
