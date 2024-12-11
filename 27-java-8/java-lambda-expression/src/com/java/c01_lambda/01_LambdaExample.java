package com.java.c01_lambda;

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle class : draw() method");
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


class LambdaExample {

    public static void main(String[] args) {

        // tradition way
        Rectangle r = new Rectangle();
        r.draw();
        Square s = new Square();
        s.draw();
        Circle c = new Circle();
        c.draw();

        // definig lambda expression
        Shape rectangle = () -> System.out.println("Rectangle class : draw() method");
        rectangle.draw();
        Shape square = () -> System.out.println("Square class : draw() method");
        square.draw();
        Shape circle = () -> System.out.println("Circle class : draw() method");
        circle.draw();

        // traditional way of calling parameter expression
        print(rectangle);
        print(square);
        print(circle);
        
        // passing lambda expression to parameter expression
        print(() -> System.out.println("Rectangle class : draw() method"));
        print(() -> System.out.println("Square class : draw() method"));
        print(() -> System.out.println("Circle class : draw() method"));
    }
    
    private static void print(Shape shape) {
        shape.draw();;
    }

}
