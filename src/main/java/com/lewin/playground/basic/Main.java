package com.lewin.playground.basic;

public class Main {
  //use underscore for more readable.
  private final long myLong = 10_000_000;
  //use Integer wrapper class
  private final int myMaxInt = Integer.MAX_VALUE;
  //an integer literal of type long always ends with L(or l);
  private final long myLongTwo = 121212L;
  //type casting:(this one not recommend that result a data loss)
  private final long myLongThree = 111111;
  private final int myInt = (int) myLongThree;
  //use Long wrapper class
  private final long myMaxLong = Long.MAX_VALUE;
  //use Unicode escape sequence
  private final char myChar = '\u0041';
  //all real number end with F or f are called float literal
  private final float myFloat = 2.32F;
  private final float myPositiveInfinity = myFloat / 0.0F;//this is positive infinity
  private final float myPositiveInfinityClone = Float.POSITIVE_INFINITY;//this is positive infinity
  private final float myNegativeInfinity = myFloat / -0.0F;//this is positive infinity
  private final float myNegativeInfinityClone = Float.NEGATIVE_INFINITY;//this is positive infinity
  private final float myNaN = Float.NaN;//this is NaN(not a number of type float)
  //double data type: (D or d suffix is optional)
  private final double myDouble = 2.3333333333333D;

  /**
   * this is documentation comments.
   * Documentation comment start with /**
   * @param args - the argument for main method
   * @return the return is void
   */
  //  To generate Java docs, execute utility with two arguments. First is location of generated Java docs,
  //  and second is Java source files. In our case, I executed this command from location where Main.java is.
  //  javadoc -d C:/temp Main.java
  public static void main(String[] args) {
    System.out.println("hello world");
  }
}
