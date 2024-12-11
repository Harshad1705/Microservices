package com.java.c01_lambda;

class ThreadDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("run method called ....");
    }
}

class LambdaRunnableExpression {

    public static void main(String[] args) {

        // traditional way to use thread
        Thread thread = new Thread(new ThreadDemo());
        thread.start();

        // lambda expression to implement runnable expression
        Runnable runnable = () -> System.out.println("Run called using lambda ...");
        Thread threadLmda = new Thread(runnable);
        threadLmda.run();
    }
    
}
