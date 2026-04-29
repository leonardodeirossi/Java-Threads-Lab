package it.leode.threads.lez03b;

public class MyTask implements Runnable {
    DijkstraSemaphore semaphore;
    
    public MyTask(DijkstraSemaphore semaphore) {
        this.semaphore = semaphore;
    }
    
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting.");
            this.semaphore.p();
            
            System.out.println(Thread.currentThread().getName() + " has entered critical section.");
            Thread.sleep(1500);     // doing something
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException");
        } finally {
            System.out.println(Thread.currentThread().getName() + " is exiting.");
            this.semaphore.v();
        }
    }
}
