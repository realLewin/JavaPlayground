package com.lewin.playground.javacourse.threadcourse.threadstarvation;

import com.lewin.playground.javacourse.threadcourse.ThreadColor;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
  //use this kind of lock will cause thread starvation;
  private static Object lock = new Object();
  //use this lock to make sure FIFO;
  private static ReentrantLock fairLock = new ReentrantLock(true);

  public static void main(String[] args) {
    Thread t1 = new Thread(new Counter(ThreadColor.ANSI_CYAN),"priority 10");
    Thread t2 = new Thread(new Counter(ThreadColor.ANSI_PURPLE),"priority 8");
    Thread t3 = new Thread(new Counter(ThreadColor.ANSI_BLUE),"priority 6");
    Thread t4 = new Thread(new Counter(ThreadColor.ANSI_GREEN),"priority 4");
    Thread t5 = new Thread(new Counter(ThreadColor.ANSI_RED),"priority 2");

    //set priority is easy to get thread starvation;
    t1.setPriority(10);
    t2.setPriority(8);
    t3.setPriority(6);
    t4.setPriority(4);
    t5.setPriority(2);

    t3.start();
    t2.start();
    t5.start();
    t4.start();
    t1.start();
  }


  private static class Counter implements Runnable {
    private int count = 0;
    private String color;

    public Counter(String color) {
      this.color = color;
    }

    @Override
    public void run() {
      for(int i = 1; i <= 100; i++){
        fairLock.lock();
        try{
          System.out.format(color + "%s: the count is %d%n", Thread.currentThread().getName(), count++);
        }finally {
          fairLock.unlock();
        }
      }
    }
    //    this is version one with thread starvation implements;
//    @Override
//    public void run() {
//      for(int i = 1; i <= 100; i++){
//        synchronized(lock){
//          System.out.format(color + "%s: the count is %d%n", Thread.currentThread().getName(), count++);
//        }
//      }
//    }
  }
}
