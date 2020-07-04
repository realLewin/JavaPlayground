package com.lewin.playground.javacourse.threadcourse.threadinteraction;

import static com.lewin.playground.javacourse.threadcourse.ThreadColor.ANSI_GREEN;
import static com.lewin.playground.javacourse.threadcourse.ThreadColor.ANSI_PURPLE;

public class Main {
  public static void main(String[] args) {
    Thread sleepThread = new Thread(new RunnableThread());
    sleepThread.start();

    Thread demoThread = new Thread(new Runnable(){
      @Override
      public void run() {
        try{
          sleepThread.join(3000);
          System.out.println(ANSI_GREEN + "sleep thread terminate or time out, I got run.");
        }catch(InterruptedException e){
          System.out.println(ANSI_GREEN + "I'm interrupted by other thread");
        }
      }
    });
    demoThread.start();

    System.out.println(ANSI_PURPLE + "I'm at the end of main");
  }
}
