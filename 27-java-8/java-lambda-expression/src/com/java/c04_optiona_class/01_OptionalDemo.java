package com.java.c04_optiona_class;

import java.util.Optional;

class OptionalDemo {

    public static void main(String[] args) {

        String email = "test@gmail.com";
        String emailNull = null;
        
        // three ways to create Optional Object :- empty , of , ofNullable

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);
        
        Optional<String> emailOptional = Optional.of(email);
        System.out.println(emailOptional);
        
        Optional<String> stringOptional = Optional.ofNullable(emailNull);
        System.out.println(stringOptional);
        
        // retrive value from optional class
        System.out.println(emailOptional.get());

        // isPresent Method 
        if (stringOptional.isPresent()) {
            System.out.println(stringOptional.get());
        } else {
            System.out.println("No value present");
        }

        // orElse method
        System.out.println(emptyOptional.orElse("default value"));
        
        // orElseGet method
        System.out.println(emptyOptional.orElseGet(() -> "default value"));
        
        // orElseThrow method
        // stringOptional.orElseThrow(() -> new IllegalArgumentException("String not exist"));

        // ifPresent method
        Optional<String> gender = Optional.of("MALE");
        gender.ifPresent((s)->System.out.println("value is present"));
        emptyOptional.ifPresent((s)->System.out.println("value is present"));


        // filter method
        String str = "abc";
        if (str != null && str == "abc") {
            System.out.println(str);
        }
        
        Optional<String> result = Optional.of("abc");
        result.filter(res -> res.contains("abc")).ifPresent((res) -> System.out.println(res));

        // map method
        String strSpace = " abc ";
        result.filter(res -> strSpace.contains("abc"))
                .map(String::trim).ifPresent((res) -> System.out.println(res));

        
    }
    
}
