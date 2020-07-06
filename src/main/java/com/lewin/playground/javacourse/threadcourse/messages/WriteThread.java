package com.lewin.playground.javacourse.threadcourse.messages;

import java.util.Random;

public class WriteThread implements Runnable {
  private Message message;

  public WriteThread(Message message){
    this.message = message;
  }

  @Override
  public void run() {
    String messages[] = new String[]{
        "this is message one.",
        "this is message two.",
        "this is message three.",
        "this is message four."
    };

    Random random = new Random();
    for(int i = 0; i < messages.length; i++){
      message.writeMes(messages[i]);
      try{
        Thread.sleep(random.nextInt(2000));
      }catch(InterruptedException e){

      }
    }
    message.writeMes("finished");
  }
}
