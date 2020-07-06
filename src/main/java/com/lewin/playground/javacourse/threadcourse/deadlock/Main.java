package com.lewin.playground.javacourse.threadcourse.deadlock;

public class Main {
  //simple deadlock example;
  private static Object lock1 = new Object();
  private static Object lock2 = new Object();

  public static void main(String[] args) {

    //this will cause a deadlock;
//    new ThreadOne().start();
//    new ThreadTwo().start();

    /**
     * there have some solutions :
     * first is use one synchronized variable(not possible in this case;
     * second is use the synchronized variable in same order;
     */
    //the second solution demo:
    //this is only for demo purpose, you should rewrite ThreadTwo to archive this goal
    new ThreadOne().start();
    new ThreadOne().start();

  }


  private static class ThreadOne extends Thread{
    @Override
    public void run() {
      synchronized (lock1){
        System.out.println("Thread 1 get lock 1");
        try{
          Thread.sleep(100);
        }catch(InterruptedException e){
          System.out.println("interrupted");
        }
        System.out.println("thread 1 waiting for lock 2");
        synchronized (lock2){
          System.out.println("thread 1 get lock1 and lock2");
        }
        System.out.println("thread 1 release lock2");
      }
      System.out.println("thread 1 release lock1");
    }
  }
  private static class ThreadTwo extends Thread{
    @Override
    public void run() {
      synchronized (lock2){
        System.out.println("Thread 2 get lock 2");
        try{
          Thread.sleep(100);
        }catch(InterruptedException e){
          System.out.println("interrupted");
        }
        System.out.println("thread 2 waiting for lock 1");
        synchronized (lock1){
          System.out.println("thread 2 get lock1 and lock2");
        }
        System.out.println("thread 2 release lock1");
      }
      System.out.println("thread 2 release lock2");
    }
  }
}
