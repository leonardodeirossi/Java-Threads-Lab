package it.leode.threads.lez01;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Main.esempio1();
        // Main.esempio2();
        // Main.esempio3();
        // Main.esempio4();
        // Main.esempio5();
    }

    public static void esempio1() {
        MyThreadFromClass myThread = new MyThreadFromClass(1);
        myThread.start();
    }

    public static void esempio2() {
        MyThreadFromInterface myThreadI = new MyThreadFromInterface(1);
        Thread myThread = new Thread(myThreadI);

        myThread.start();
    }

    public static void esempio3() {
        List<MyThreadFromClass> myThreadPool = new ArrayList<>(10);

        for (int i = 1; i <= 10; i++) {
            myThreadPool.add(new MyThreadFromClass(i));
        }

        myThreadPool.forEach((thread) -> {
            thread.start();
        });
    }
    
    public static void esempio4() {
        MyThreadFromClass myThread1 = new MyThreadFromClass(1);
        MyThreadFromClass myThread2 = new MyThreadFromClass(2);
        
        myThread1.start();
        myThread2.start();
        
        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException ex) {
            // -----
        }
        
        System.out.println("Hanno finito sia myThread1 che myThread2.");
    }
    
    public static void esempio5() {
        WaitingThread wt1 = new WaitingThread(1, 5);
        WaitingThread wt2 = new WaitingThread(2, 3);
        
        wt1.start();
        wt2.start();
        
        try {
            wt1.join();
            wt2.join();
        } catch (InterruptedException ex) {
            // ----
        }
        
        System.out.println("Hanno finito sia wt1 che wt2.");
    }
}
