package com.lewin.playground.javacourse.threadcourse.counter;

import static com.lewin.playground.javacourse.threadcourse.ThreadColor.*;

public class Counter {
  //this variable is stored in the heap shared by threads;
  private int i;

  //use synchronized keywords with method declaration not recommend
  //you should synchronize as small as possible block;
  //public void synchronized doCounter(){
  public void doCounter() {
    String color;
    String threadName = Thread.currentThread().getName();
    switch (threadName) {
      case "thread one":
        color = ANSI_GREEN;
        break;
      case "thread two":
        color = ANSI_PURPLE;
        break;
      default:
        color = ANSI_RED;
        break;
    }
    //this will cause problems;
    //  for(i = 10; i > 0; i--){
    //    System.out.println(color + threadName + ": i = " + i);
    //  }
    //this variable is stored in thread stack not share by threads each other;
    //  for(int i = 10; i > 0; i--){
    //    System.out.println(color + threadName + ": i = " + i);
    //  }

    //another synchronized use;
    //this is recommend way;
    synchronized (this) {
      for (i = 10; i > 0; i--) {
        System.out.println(color + threadName + ": i = " + i);
      }
    }
  }
}
