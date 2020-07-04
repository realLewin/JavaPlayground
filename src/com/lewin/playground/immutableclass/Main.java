package com.lewin.playground.immutableclass;

import java.util.Date;

public class Main {
  private static ImmutableClass testClass =
      ImmutableClass.createImmutableClass(12, "lewin",new Date());

  public static void main(String[] args) {
    System.out.println(testClass.toString());
    modifyTestClass(testClass.getImmutableInteger(), testClass.getImmutableString(),testClass.getMutableDate());
    System.out.println(testClass.toString());
  }

  private static void modifyTestClass(Integer i, String s, Date d){
    i = 1111;
    s = "blablabla";
    d.setTime(1111);
  }
}
