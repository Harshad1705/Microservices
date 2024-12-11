package com.java.c05_default_and_static_methods_in_interface;

interface Vehicle {

    String getBrand();

    String speedUp();

    String speedDown();

    default String turnAlarmOn() {
        return "turning vehicle alarm on";
    }

    default String turnAlarmOff() {
        return "turning vehicle alarm off";
    }

    static String getCompany() {
        return "Audi";
    }
}

class Car implements Vehicle {

    @Override
    public String getBrand() {
        return "BMW";
    }

    @Override
    public String speedUp() {
        return "car is speeding up";
    }
    
    @Override
    public String speedDown() {
        return "car is slowing down";
    }
    
}

class DefaultDemo {

    public static void main(String[] args) {
        
        Car car = new Car();

        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.speedDown());

        System.out.println(car.turnAlarmOn());
        System.out.println(car.turnAlarmOff());
        
        System.out.println(Vehicle.getCompany());
    }
    
}
