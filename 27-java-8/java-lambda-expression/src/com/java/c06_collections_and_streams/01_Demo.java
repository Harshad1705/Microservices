package com.java.c06_collections_and_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {

        // List collection is used to store data
        List<String> fruits = new ArrayList<>();

        // Adding new elements to the ArrayList
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("mango");
        fruits.add("orange");

        // Streams are used to perform operations like filtering, mapping, collection result, etc:
        List<String> result = fruits.stream() // convert list to stream
                .filter(line -> !"Apple".equals(line))
                .collect(Collectors.toList()); // collect the output and convert streams to a List

        result.forEach(System.out::println);

        System.out.println();
        
        fruits.forEach(System.out::println);
    }

    

}