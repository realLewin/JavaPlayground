package com.lewin.playground.basic.wrapperclass;

public class Main {
  /**
   When to use wrapper classes
   Java wrapper classes are used in scenarios –

   When two methods wants to refer to the same instance of an primitive type, then pass wrapper
   class as method argument.
   Generics in Java works only with object and does not support primitive types.
   Collections in Java deal only with objects; to store a primitive type in one of these classes,
   you need to wrap the primitive type in a class.
   When you want to refer null from data type, the you need object. Primitives cannot have null as value.

   There are two ways for converting a primitive type into an object of corresponding wrapper class –

   using constrcutors
   using static factory methods such as valueOf() (except Character)
   *
   */
  Integer intObj = new Integer(12);
  Integer intObjClone = Integer.valueOf(12);
  int myInt = intObj.intValue();//wrapper to primitive:
  Character charObj = 'a';//autoboxing
  int myIntClone  = intObj;//unboxing

  public static void main(String[] args) {

  }
}
