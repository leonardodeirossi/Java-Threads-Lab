package it.leode.threads.lez01;

public class WaitingThread extends MyThreadFromClass {
    private final int waitTime;
    
    public WaitingThread(int threadNumber, int waitTime) {
        super(threadNumber);
        this.waitTime = waitTime;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(this.waitTime * 1000);
            System.out.println("Ciao da Thread #" + super.getThreadNumber() + "!");
        } catch (InterruptedException ex) {
            // -----
        }
    }
}
