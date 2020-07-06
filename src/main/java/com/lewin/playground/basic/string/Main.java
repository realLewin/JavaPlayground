package com.lewin.playground.basic.string;

public class Main {
  public static void main(String[] args) {
    /**
     * String literals are stored in String pool, a special memory area created by JVM.
     * There can be only one instance of one String. Any second String with same character
     * sequence will have the reference of first string stored in string pool. It makes
     * efficient to work with Strings and saves lots of physical memory in runtime.
     */
    String myString = "this is a string";
    String myStringClone = "this is a string";//this one reference the first one

    /**
     * At times, we may wish to create separate instance for each separate string in memory.
     * We can create one string object per string value using new keyword.
     *
     * String objects created using new keyword – are stored in heap memory.
     */
    String stringHeap = new String("string store in heap");
    String stringHeapClone = new String("string store in heap");//these two are separate string

    //there are many String methods, this is just one sample;
    String stringMethod = "this is sample string";
    stringMethod.charAt(3);//output 's';

  }
}
