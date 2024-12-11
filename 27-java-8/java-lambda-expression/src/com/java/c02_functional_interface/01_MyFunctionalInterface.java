package com.java.c02_functional_interface;

@FunctionalInterface // optional
interface MyFunctionalInterface {

    void print(String text);

    default void m1() {
        System.out.println("Default method");
    }

    static void m2() {
        System.out.println("Static method");
    }
}
