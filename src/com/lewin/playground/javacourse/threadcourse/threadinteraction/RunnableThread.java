package com.lewin.playground.javacourse.threadcourse.threadinteraction;

import static com.lewin.playground.javacourse.threadcourse.ThreadColor.ANSI_YELLOW;

public class RunnableThread implements Runnable {
  @Override
  public void run() {
    System.out.println(ANSI_YELLOW + "sleep thread begin");
    try{
      Thread.sleep(4000);
    }catch(InterruptedException e){
      System.out.println(ANSI_YELLOW + "I'm interrupted by other thread");
      return;//terminate the thread
    }
    System.out.println(ANSI_YELLOW + "seconds passed, I'm awake");
  }
}
