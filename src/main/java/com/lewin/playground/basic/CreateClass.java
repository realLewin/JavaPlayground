package com.lewin.playground.basic;

public class CreateClass {
  //two type of class: abstract and non-abstract

  //instance initialization block:
  /**
   * We saw that a constructor is used to initialize an instance of a class.
   * An instance initialization block, also called instance initializer, is also used to
   * initialize objects of a class.
   *
   * An instance initializer is simply a block of code inside the body of a class, but outside
   * of any methods or constructors. An instance initializer does not have a name. Its code is simply
   * placed inside an opening brace and a closing brace.
   *
   * Note that an instance initializer is executed in instance context and the keyword this is
   * available inside the instance initializer.
   *
   * we can have multiple instance initializers for a class.
   * All initializers are executed automatically in textual order for every object we create.
   * Code for all instance initializers are executed before any constructor.
   * An instance initializer cannot have a return statement.
   * It cannot throw checked exceptions unless all declared constructors list those checked exceptions in their throws clause.
   */
  {
    System.out.println("this is an instance initializer block");
  }

  /**
   * A static initialization block is also known as a static initializer.
   * It is similar to an instance initialization block except it is used to initialize a class.
   * An instance initializer is executed once per object whereas a static initializer is executed
   * only once for a class when the class definition is loaded into JVM.
   * To differentiate it from an instance initializer, we need to use the static keyword in the
   * beginning of its declaration.
   * we can have multiple static initializers in a class.
   * All static initializers are executed in textual order in which they appear, and execute before
   * any instance initializers.
   *
   * A static initializer cannot throw checked exceptions. It cannot have a return statement.
   */
  static {
    System.out.println("this is static initialization block");
  }

  //The new operator creates an instance of a class by allocating the memory in heap.

  //The null reference type is assignment compatible with any other reference type.
  //null is a literal of null type. We cannot assign null to a primitive type variable
  //that’s why Java compiler does not allow us to compare a primitive value to a null value.
  //e.g. CreateClass myClass = null; //not refer to any object;

}
