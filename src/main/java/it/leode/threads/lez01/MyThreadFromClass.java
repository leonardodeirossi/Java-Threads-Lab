package it.leode.threads.lez01;

public class MyThreadFromClass extends Thread {

    private final int threadNumber;

    public MyThreadFromClass(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("Ciao da Thread #" + this.threadNumber + "!");
    }
    
    public int getThreadNumber() {
        return this.threadNumber;
    }
}
