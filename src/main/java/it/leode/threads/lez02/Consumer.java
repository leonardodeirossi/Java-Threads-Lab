package it.leode.threads.lez02;

public class Consumer implements Runnable {

    private Buffer buffer;

    // Q: che tipo di passaggio viene fatto per buffer?
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            this.buffer.consume();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                // ---
            }
        }
    }
    
    /*
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            this.buffer.consume();
        }
    }
     */
}
