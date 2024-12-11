By understanding Java 8 features, you'll be better equipped to write clean, modern, and efficient Java code in a functional style.

With the introduction of Java 8 features, you can now take advantage of functional programming principles, which will help you:

Reduce Boilerplate Code: Functional programming minimizes repetitive tasks and verbose code. For example, lambda expressions allow you to replace long, anonymous inner classes with a single line of code.

Improve Readability: Code written in a functional style is often more declarative and easier to understand, especially when working with collections, filtering, and transformation operations.

Increase Productivity: The Streams API and functional interfaces enable you to handle data transformations more elegantly, leading to faster and more productive coding.

Write Safer Code: By using functional programming concepts like immutability, method references, and the Optional class, your code can be more reliable, with fewer bugs related to null values and side effects.

---

Functional Interface -

- Fuctiona interface were introduced in Java 8.
- An interface that contain exactly one abstract method is known as functiona interface.
- interface MyFuctionalInterface {
  public void exectute();
  }
- Fuctional interface can have any number of default, static methods but can contain only one abstract method.
- interface MyFuctionalInterface {
  public void exectute();
  public default void print(String text){
  System.out.println(text);
  }
  public static void print(String text){
  System.out.println(text);
  }
  }
- We use Java 8 provides the @FunctionalInterface annotation to mark an interface as a Functional Interface.

---

Lambda Expressions -

- Lambda Expressions were introduced in Java 8.
- Lambda expression is an anonymous function. It's a function without name
  and does not belong to any class.
- Lambda expression is mainly used to implement funtional interfaces.

---

Lambda vs Method -

- Method is always belongs to class or object in Java where as Lambda does not belongs to any class or object.
- Method has the main parts:
  - Name
  - Parameter List
  - Body
  - Return Type
- Lambda expression in java has three main parts:
  - No Name :- A lambda is an anonymous fucntion so no need to have a name.
  - Parameter List
  - Body - This is the main part of the function.
  - No return type - No need to mention return type in lambda expression. Java 8+ compiler is smart enough to identify the return type of expression.

---

Method References -

- Java provides a new feature called method reference in Java 8.
- Method reference is used to refer method of the functional interface. It is compact and easy form of a lambda expression.
- Each time when you are using lambda expression to just referring a method, you can replace your lambda expression with a method reference.

-Types of Method References
There are four types of method references in Java:

1. Method reference to static method: its syntax is Class::StaticMethodName
2. Reference to an instance method of a particular object : the syntax is Object:: instanceMethodName
3. Reference to an instance method of an arbitrary object of specific type: the syntax is Class::instanceMethodName
4. Reference to a constructor: its syntax is ClassName::new

---

Java Optional Class -

- Java 8 has introduced a new Optional utility class in java.utli.pacakage. This class can help in avoiding null checks and NullPointerException exceptions.
- You can view Optional as a single-value container that either conatins a value or doesn't.

---

Difference between Collections and Streams -

Collections -

- Collections are used to store and group the data in a particular data structure ike List, Set or Map.
- You can add or remove elements from collections.
- Collections have to be iterated externally (Using for loops).
- Collections can be traversed multiple times.
- Collections are eagerly constructed.

Streams -

- Streams are used to perform complex data processing operations like filtering, matching, mapping stored data such as arrays, collections or I/O resources.
- You can't add or remove elements from streams.
- Streams are internally iterated (using forEach() method).
- Streams are traversable only once.
- Streams are lazily constructed.
