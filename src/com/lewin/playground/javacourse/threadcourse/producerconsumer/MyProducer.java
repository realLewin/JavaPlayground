package com.lewin.playground.javacourse.threadcourse.producerconsumer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.lewin.playground.javacourse.threadcourse.producerconsumer.Main.EOF;

public class MyProducer implements Runnable {
  private String color;
  private List<String> buffer;
  private ReentrantLock bufferLock;

  public MyProducer(String color, List<String> buffer, ReentrantLock bufferLock) {
    this.color = color;
    this.buffer = buffer;
    this.bufferLock = bufferLock;
  }

  @Override
  public void run() {
    String[] messages = {"hello", "I'm there", "don't worry", "that's OK"};
    Random random = new Random();
    for (String m : messages) {
      try {
        System.out.println(color + "add message...");
        bufferLock.lock();
        try {
          buffer.add(m);
        } finally {
          bufferLock.unlock();
        }
        Thread.sleep(random.nextInt(1000));
      } catch (InterruptedException e) {
        System.out.println(color + "I'm interrupted");
      }
    }
    bufferLock.lock();
    try {
      buffer.add(EOF);
    } finally {
      bufferLock.unlock();
    }
    System.out.println(color + "add EOF and complete");
  }
}

/**
 * producer version one use synchronized(not recommend);
 */

//package com.lewin.playground.javacourse.threadcourse.producerconsumer;
//
//import java.util.List;
//import java.util.Random;
//import static com.lewin.playground.javacourse.threadcourse.producerconsumer.Main.EOF;
//
//public class MyProducer implements Runnable {
//  private String color;
//  private List<String> buffer;
//
//  public MyProducer(String color, List<String> buffer) {
//    this.color = color;
//    this.buffer = buffer;
//  }
//
//  @Override
//  public void run() {
//    String[] messages = {"hello", "I'm there", "don't worry", "that's OK"};
//    Random random = new Random();
//    for(String m: messages){
//      try{
//        System.out.println(color + "add message...");
//        synchronized (buffer){
//          buffer.add(m);
//        }
//        Thread.sleep(random.nextInt(1000));
//      }catch(InterruptedException e){
//        System.out.println(color + "I'm interrupted");
//      }
//    }
//    synchronized (buffer){
//      buffer.add(EOF);
//    }
//    System.out.println(color + "add EOF and complete");
//  }
//}
