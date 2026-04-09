package it.leode.threads.lez01;

public class MyThreadFromInterface implements Runnable {

    private final int threadNumber;

    public MyThreadFromInterface(int threadNumber) {
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
