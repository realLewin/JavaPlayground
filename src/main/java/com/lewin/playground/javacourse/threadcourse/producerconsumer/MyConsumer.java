package com.lewin.playground.javacourse.threadcourse.producerconsumer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static com.lewin.playground.javacourse.threadcourse.producerconsumer.Main.EOF;

public class MyConsumer implements Runnable {
  private String color;
  private List<String> buffer;
  private ReentrantLock bufferLock;
  private int counter = 0;

  public MyConsumer(String color, List<String> buffer, ReentrantLock bufferLock) {
    this.color = color;
    this.buffer = buffer;
    this.bufferLock = bufferLock;
  }

  /**
   * use try finally block is recommended way;
   */
  @Override
  public void run() {
    while (true) {
      //bufferLock.lock();
      if (bufferLock.tryLock()){
        try {
          if (buffer.isEmpty()) {
            continue;
          }
//          System.out.println("the counter is: " + counter);
          counter = 0;
          if (buffer.get(0).equals(EOF)) {
            System.out.println(color + "read complete and exiting...");
            break;
          } else {
            System.out.println(color + "removing: " + buffer.remove(0));
          }
        } finally {
          bufferLock.unlock();
        }
      }
      else{
        counter++;
      }
    }
  }
}

/**
 * consumer version one use synchronized(not recommend);
 */


//package com.lewin.playground.javacourse.threadcourse.producerconsumer;
//
//import java.util.List;
//
//import static com.lewin.playground.javacourse.threadcourse.producerconsumer.Main.EOF;
//
//public class MyConsumer implements Runnable {
//  private String color;
//  private List<String> buffer;
//
//  public MyConsumer(String color, List<String> buffer) {
//    this.color = color;
//    this.buffer = buffer;
//  }
//
//  @Override
//  public void run() {
//    while (true) {
//      synchronized (buffer) {
//
//        if (buffer.isEmpty()) {
//          continue;
//        }
//        if (buffer.get(0).equals(EOF)) {
//          System.out.println(color + "read complete and exiting...");
//          break;
//        } else {
//          System.out.println(color + "removing: " + buffer.remove(0));
//        }
//      }
//    }
//  }
//}
