package com.java.c02_functional_interface;

import java.util.function.Function;

class FunctionalImpl implements Function<String,Integer> {

    @Override
    public Integer apply(String str) {
        return str.length();
    }
    
}

class FunctionDemo {
    public static void main(String[] args) {

        // traditional way
        Function<String, Integer> function = new FunctionalImpl();
        System.out.println(function.apply("Harshad"));

        // use lambda expression to implement this functional interface
        Function<String, Integer> functionLmbd = (String s) -> s.length();
        System.out.println(functionLmbd.apply("Harshad"));
        
    }
}
