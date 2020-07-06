package com.lewin.playground.basic.array;

public class Main {
  public static void main(String[] args) {
    char[] myChars;//declaration
    char myCharsClone[] = new char[12];//declaring and allocating memory
    char[] myCharCloneAgain = {'a', 'c', 'b'};//simple one
    boolean[] myBooleans = new boolean[]{true, false, true};//array literal
    boolean outsizeBool = myBooleans[5];//JVM throws ArrayIndexOutOfBoundsException
    double[][] myDoubles = new double[12][];//multidimensional arrays
    boolean[] myBooleanClone = myBooleans.clone();//array clone(shallow copy);
  }
}
