package it.leode.threads.lez03;

import java.util.concurrent.Semaphore;

public class Stampante {
    public final Semaphore semaforo;
    
    public Stampante() {
        this.semaforo = new Semaphore(1);
    }
    
    public Stampante(int copieConcorrenti) {
        this.semaforo = new Semaphore(copieConcorrenti);
    }
    
    public Semaphore getSemaforo() {
        return this.semaforo;
    }
}
