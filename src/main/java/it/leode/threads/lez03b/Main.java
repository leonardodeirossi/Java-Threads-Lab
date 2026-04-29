package it.leode.threads.lez03b;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        DijkstraSemaphore semaforo = new DijkstraSemaphore(1);
    
        for (int i = 0; i < 5; i++) {
            MyTask task = new MyTask(semaforo);
            Thread taskThread = new Thread(task);
            
            taskThread.start();
        }
    }
}
