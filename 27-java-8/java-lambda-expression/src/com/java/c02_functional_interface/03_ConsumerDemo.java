package com.java.c02_functional_interface;

import java.util.function.Consumer;

class ConsumerImpl implements Consumer<String> {

    @Override
    public void accept(String str) {
        System.out.println(str);
    }
    
}

class ConsumerDemo {

    public static void main(String[] args) {

        Consumer<String> consumer = new ConsumerImpl();
        consumer.accept("Harshad");

        Consumer<String> consumerLmbd = (str) -> System.out.println(str);
        consumerLmbd.accept("Harshad");
        
    }
    
}
