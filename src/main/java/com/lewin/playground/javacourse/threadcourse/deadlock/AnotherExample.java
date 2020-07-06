package com.lewin.playground.javacourse.threadcourse.deadlock;

public class AnotherExample {

  public static void main(String[] args) {
   People lewin = new People("lewin");
   People jenny = new People("jenny");
    /**
     * this example is same thing as previous one(the Main example);
     * when lewin call greeting back, jenny is hold the jenny lock
     * when jenny call greeting back, lewin is hold the lewin lock
     */
   new Thread(new Runnable(){
     @Override
     public void run() {
       lewin.greeting(jenny);
     }
   }).start();
   new Thread(new Runnable(){
     @Override
     public void run() {
       jenny.greeting(lewin);
     }
   }).start();
  }

  private static class People{
    private String name;

    public People(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public synchronized void greeting(People people){
      System.out.format("%s: %s has greeted to me%n", this.name, people.getName());
      people.greetingBack(this);
    }

    public synchronized void greetingBack(People people){
      System.out.format("%s: %s has greeted back to me%n", this.name, people.getName());
    }
  }
}
