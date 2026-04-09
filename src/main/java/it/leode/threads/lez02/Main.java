package it.leode.threads.lez02;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World! (2)");

        Buffer sharedBuffer = new Buffer();

        Thread producerThread = new Thread(new Producer(sharedBuffer));
        Thread consumerThread = new Thread(new Consumer(sharedBuffer));

        producerThread.start();
        consumerThread.start();
    }
}
