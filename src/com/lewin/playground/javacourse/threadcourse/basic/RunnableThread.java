package com.lewin.playground.javacourse.threadcourse.basic;

import static com.lewin.playground.javacourse.threadcourse.ThreadColor.ANSI_RED;

public class RunnableThread implements Runnable {
  @Override
  public void run() {
    System.out.println(ANSI_RED + "hello from runnable thread");
  }
}
