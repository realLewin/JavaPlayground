package com.lewin.playground.javacourse.threadcourse.counter;

public class CounterThread implements Runnable {
  private Counter threadCounter;
  public CounterThread(Counter threadCounter){
    this.threadCounter = threadCounter;
  }

  @Override
  public void run() {
    this.threadCounter.doCounter();
  }
}
