package com.lewin.playground.basic.immutableclass;

/**
 * Rules to create immutable class:
 * Don’t provide “setter” methods — methods that modify fields or objects referred to by fields.
 * Make all fields final and private
 * Don’t allow subclasses to override methods(use final class)
 * Special attention when having mutable instance variables
 */

import java.util.Date;

/**
 * Always remember that your instance variables will be either mutable or immutable.
 * Identify them and return new objects with copied content for all mutable objects.
 * Immutable variables can be returned safely without extra effort.
 *
 * A more sophisticated approach is to make the constructor private and construct instances in factory methods.
 * */

public final class ImmutableClass {
  /**
   * Integer class is immutable as it does not provide any setter to change its content
   * */
  private final Integer immutableInteger;
  /**
   * String class is immutable as it also does not provide setter to change its content
   * */
  private final String immutableString;
  /**
   * Date class is mutable as it provide setters to change various date/time parts
   * */
  private final Date mutableDate;

  //Default private constructor will ensure no unplanned construction of class
  private ImmutableClass(Integer immutableInteger, String immutableString, Date mutableDate){
    this.immutableInteger = immutableInteger;
    this.immutableString = immutableString;
    this.mutableDate = mutableDate;
  }

  //Factory method to store object creation logic in single place
  public static ImmutableClass createImmutableClass(Integer immutableInteger, String immutableString, Date mutableDate){
    return new ImmutableClass(immutableInteger, immutableString, mutableDate);
  }

  //Provide no setter methods

  /**
   * Integer class is immutable so we can return the instance variable as it is
   * */
  public Integer getImmutableInteger() {
    return immutableInteger;
  }

  /**
   * String class is also immutable so we can return the instance variable as it is
   * */
  public String getImmutableString() {
    return immutableString;
  }

  /**
   * Date class is mutable so we need a little care here.
   * We should not return the reference of original instance variable.
   * Instead a new Date object, with content copied to it, should be returned.
   * */
  public Date getMutableDate() {
    return new Date(mutableDate.getTime());
  }

  @Override
  public String toString(){
    return immutableInteger +" - "+ immutableString +" - "+ mutableDate;
  }
  /**
   * Apart from your written classes, JDK itself has lots of immutable classes.
   * Given is such a list of immutable classes in Java.
   *
   * String
   * Wrapper classes such as Integer, Long, Double etc.
   * Immutable collection classes such as Collections.singletonMap() etc.
   * java.lang.StackTraceElement
   * Java enums (ideally they should be)
   * java.util.Locale
   * java.util.UUID
   */
  /**
   * Benefits of making a class immutable
   *
   * are simple to construct, test, and use
   * are automatically thread-safe and have no synchronization issues
   * do not need a copy constructor
   * do not need an implementation of clone
   * allow hashCode() to use lazy initialization, and to cache its return value
   * do not need to be copied defensively when used as a field
   * make good Map keys and Set elements (these objects must not change state while in the collection)
   * have their class invariant established once upon construction, and it never needs to be checked again
   * always have “failure atomicity” (a term used by Joshua Bloch) : if an immutable object throws an exception,
   * it’s never left in an undesirable or indeterminate state
   */
}
