package com.lewin.playground.javacourse.threadcourse.producerconsumer;

import com.lewin.playground.javacourse.threadcourse.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
  public static final String EOF = "EOF";
  private static ReentrantLock bufferLock = new ReentrantLock();
  private static List<String> buffer = new ArrayList<>();
  private static ExecutorService executorService = Executors.newFixedThreadPool(3);

  public static void main(String[] args) {
//    new Thread(new MyProducer(ThreadColor.ANSI_YELLOW, buffer, bufferLock)).start();
//    new Thread(new MyConsumer(ThreadColor.ANSI_PURPLE, buffer, bufferLock)).start();
//    new Thread(new MyConsumer(ThreadColor.ANSI_CYAN, buffer, bufferLock)).start();

    executorService.execute(new MyProducer(ThreadColor.ANSI_YELLOW, buffer, bufferLock));
    executorService.execute(new MyConsumer(ThreadColor.ANSI_PURPLE, buffer, bufferLock));
    executorService.execute(new MyConsumer(ThreadColor.ANSI_CYAN, buffer, bufferLock));

    //this is a thread that can return value;
    Future<String> future = executorService.submit(new Callable<String>() {
      @Override
      public String call() throws Exception {
        System.out.println(ThreadColor.ANSI_WHITE + "this is printed by Callable");
        return "this is returned by Callable";
      }
    });

    try{
      System.out.println(future.get());
    }catch(ExecutionException e){
      System.out.println("something went wrong");
    }catch(InterruptedException e){
      System.out.println("I'm Interrupted");
    }

    executorService.shutdown();
  }
}
