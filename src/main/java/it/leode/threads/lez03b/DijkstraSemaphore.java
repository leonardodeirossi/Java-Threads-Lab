package it.leode.threads.lez03b;

public class DijkstraSemaphore {

    private int value;

    public DijkstraSemaphore(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("[" + this.getClass().getName() + "] Value of (value=" + value + ") not valid.");
        }
        
        this.value = value;
    }
    
    // Proberen (require permit)
    public synchronized void p() throws InterruptedException {
        while (this.value == 0) {
            wait();
        }
        
        this.value--;
    }
    
    // Verhogen (release permit)
    public synchronized void v() {
        this.value++;
        notify();
    }
}
