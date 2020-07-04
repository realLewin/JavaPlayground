package com.lewin.playground.javacourse.threadcourse.counter;

public class Main {
  public static void main(String[] args) {
    Counter counter = new Counter();
    Thread threadOne = new Thread(new CounterThread(counter));
    threadOne.setName("thread one");
    Thread threadTwo = new Thread(new CounterThread(counter));
    threadTwo.setName("thread two");

    threadOne.start();
    threadTwo.start();
  }
}
