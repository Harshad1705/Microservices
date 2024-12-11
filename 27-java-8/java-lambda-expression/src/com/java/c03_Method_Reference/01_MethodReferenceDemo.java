package com.java.c03_Method_Reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Printable {
    void print(String msg);
}

class MethodReferenceDemo {

    public void display(String str) {
        str = str.toUpperCase();
        System.out.println(str);
    }

    public static Integer addition(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        
        // 1. Method reference to a static method

        // lambda expression
        Function<Integer, Double> function = (input) -> Math.sqrt(input);
        System.out.println(function.apply(4));
        
        // using method reference
        Function<Integer, Double> functionMetRef = Math::sqrt;
        System.out.println(functionMetRef.apply(4));
        
        // lambda expression
        BiFunction<Integer, Integer, Integer> biFunctionLmbd = (a, b) -> MethodReferenceDemo.addition(a, b);
        System.out.println(biFunctionLmbd.apply(10, 20));
        
        // using method reference
        BiFunction<Integer, Integer, Integer> biFunctionMetRef = MethodReferenceDemo::addition;
        System.out.println(biFunctionMetRef.apply(10, 20));


        // 2. Method Reference to an instance method of an object

        MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();

        // lambda expression
        Printable printable = (str) -> methodReferenceDemo.display(str);
        printable.print("hello world!");

        // using method reference
        Printable printableMetRef = methodReferenceDemo::display;
        printableMetRef.print("hello world!");


        // 3. Reference to an instance method of an arbitrary object
        // Sometimes, we call a method of argument in the lambda expression
        // In that case, we can use a method reference to call an instance
        // method of an arbitrary object to an specific type

        // lambda expression
        Function<String, String> strFunction = (String str) -> str.toLowerCase();
        System.out.println(strFunction.apply("HARSHAD"));

        // using method reference
        Function<String, String> strFunctionMetRef = String::toLowerCase;
        System.out.println(strFunctionMetRef.apply("HARSHAD"));

        String[] strArray = { "A", "E", "I", "O", "U", "a", "e", "i", "o", "u" };

        // using lambda expression
        Arrays.sort(strArray, (s1, s2) -> s1.compareToIgnoreCase(s2));
        
        // using method reference
        Arrays.sort(strArray, String::compareToIgnoreCase);

        // 4. Reference to a constructor

        // lambda expression
        List<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Watermelon");
        fruits.add("Apple");
        fruits.add("Apple");

        Function<List<String>, Set<String>> setFunction = (fruitList) -> new HashSet<>(fruits);
        System.out.println(setFunction.apply(fruits));

        // using method reference
        Function<List<String>, Set<String>> setFunctionMetRef = HashSet::new;
        System.out.println(setFunctionMetRef.apply(fruits));



    }
    
}
