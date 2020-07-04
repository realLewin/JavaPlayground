package com.lewin.playground.javacourse.threadcourse.basic;

import static com.lewin.playground.javacourse.threadcourse.ThreadColor.ANSI_BLUE;

public class ThreadDemoOne extends Thread {
  @Override
  public void run() {
    System.out.println(ANSI_BLUE + "hello from thread demo one");
  }
}
