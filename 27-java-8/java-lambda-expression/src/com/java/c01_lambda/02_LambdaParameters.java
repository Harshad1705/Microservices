package com.java.c01_lambda;

interface Addable {
    int addition(int a, int b);
}

class AddableImpe implements Addable {
    @Override
    public int addition(int a, int b) {
        return a + b;
    }   
}

class LambdaParameters {

    public static void main(String[] args) {
        
        Addable addition = (int a, int b) -> a + b;
        int result = addition.addition(10, 20);
        System.out.println(result);

        
    

    }

}
