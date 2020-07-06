package com.lewin.playground.basic.controlflow;

public class Main {

  private static int[] myIntegers = new int[] {1,2,3,4};

  public static void main(String[] args) {
    //for-each loop:
    for(int i: myIntegers){
      System.out.println(i);
    }
    //labeled statement:(not recommend to use)
    loop: for(int i=0; i < 6; i++)
    {
      if(i % 2 == 0)
      {
        System.out.println("In if block :: " + i);
        continue loop;
      }
      else
      {
        System.out.println("In else block :: " + i);
      }
    }
    //another labeled statement
    outer: for (int i = 0; i > 10; i++) {
      inner: for (int j = 10; j > 0; j--) {
        if (i != j) {
          System.out.println(i);
          break outer;
        }else{
          System.out.println("-->>" + i);
          continue inner;
        }
      }
    }
    /**
     * Java does not have a general goto statement.
     * The statements break and continue in Java alter the normal control flow of compound statements.
     * They can use labels which are valid java identifiers with a colon.
     * Labeled blocks can only be used with break and continue statements.
     * They must be called within its scope. You can not refer them scope of labeled block.
     * The break statement immediately jumps to the end (and out) of the appropriate compound statement.
     * The continue statement immediately jumps to the next iteration (if any) of the appropriate loop.
     * A continue statement does not apply to a switch statement or a block statement, only to compound
     * statements that loop: for, while, and do.
     */
  }
}
