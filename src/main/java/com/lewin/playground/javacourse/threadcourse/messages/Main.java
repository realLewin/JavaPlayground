package com.lewin.playground.javacourse.threadcourse.messages;

public class Main {
  private static Message message = new Message();

  public static void main(String[] args) {
    Thread writeThread = new Thread(new WriteThread(message));
    Thread readThread = new Thread(new ReadThread(message));

    writeThread.start();
    readThread.start();
  }
}
