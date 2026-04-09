package it.leode.threads.lez02;

public class Buffer {

    private int data;
    private boolean isAvailable = false;

    public synchronized void produce(int newData) {
        while (this.isAvailable) {
            try {
                wait();
            } catch (InterruptedException ex) {
                // ---
            }
        }

        this.data = newData;
        this.isAvailable = true;

        System.out.println("New product: " + newData);
        notifyAll();
    }

    public synchronized int consume() {
        while (!this.isAvailable) {
            try {
                wait();
            } catch (InterruptedException ex) {
                // ---
            }
        }

        this.isAvailable = false;
        System.out.println("Consumed: " + this.data);

        notifyAll();

        return this.data;
    }

    /*
    public void produce(int newData) {
        if (!this.isAvailable) {
            this.data = newData;
            this.isAvailable = true;

            System.out.println("New product: " + newData);
        }
    }

    public int consume() {
        this.isAvailable = false;
        System.out.println("Consumed: " + this.data);

        return this.data;
    }
     */
}
