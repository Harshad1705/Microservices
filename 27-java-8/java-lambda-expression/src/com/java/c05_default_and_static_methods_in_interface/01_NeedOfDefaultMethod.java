package com.java.c05_default_and_static_methods_in_interface;

interface Shape {
    void draw();

    default void m1() {
        System.out.println("Shape deafult method");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle class : draw() method");
    }

    @Override
    public void m1() {
        System.out.println("Rectangle default method");
    }
    
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square class : draw() method");
    }

}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle class : draw() method");
    }

}

class NeedOfDefaultMethod {

    public static void main(String[] args) {
        
        Rectangle rectangle = new Rectangle();
        rectangle.m1();

        Circle circle = new Circle();
        circle.m1();
        
    }
    
}
