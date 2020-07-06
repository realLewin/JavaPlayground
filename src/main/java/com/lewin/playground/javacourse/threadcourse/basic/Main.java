package com.lewin.playground.javacourse.threadcourse.basic;

import static com.lewin.playground.javacourse.threadcourse.ThreadColor.ANSI_GREEN;
import static com.lewin.playground.javacourse.threadcourse.ThreadColor.ANSI_PURPLE;

public class Main {
  public static void main(String[] args) {
    System.out.println(ANSI_PURPLE + "hello from main thread");

    //implement thread use Thread subclass
    Thread demoThread = new ThreadDemoOne();
    //one instance only can start once;
    demoThread.start();

    //anonymous thread
    new Thread(){
      public void run() {
        System.out.println(ANSI_GREEN + "hello from anonymous thread");
      }
    }.start();

    //implement thread use runnable interface
    Thread runnableThread = new Thread(new RunnableThread());
    runnableThread.start();

    System.out.println(ANSI_PURPLE + "hello from main thread again");
  }
}
