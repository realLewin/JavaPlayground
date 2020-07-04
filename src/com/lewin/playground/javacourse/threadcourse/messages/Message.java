package com.lewin.playground.javacourse.threadcourse.messages;

public class Message {
  private String message;
  private boolean isEmpty = true;

  public synchronized void writeMes(String message){
    while(!isEmpty){
      try{
        wait();
      }catch(InterruptedException e){

      }
    }
    isEmpty = false;
    this.message = message;
    notifyAll();
  }

  public synchronized String readMes(){
    while(isEmpty){
      try{
        wait();
      }catch(InterruptedException e){

      }
    }
    isEmpty = true;
    notifyAll();
    return this.message;
  }
}
