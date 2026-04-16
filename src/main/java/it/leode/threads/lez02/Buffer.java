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
        
        // Q: Che differenza c'e' tra notify() e notifyAll() ?
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

        // Q: Che differenza c'e' tra notify() e notifyAll() ?
        // A: notify() "risveglia" un solo thread in attesa (wait) in maniera
        //    arbitraria e dipendente dall'implementazione della JVM e dallo
        //    scheduler del sistema operativo.
        //    notifyAll() "risveglia" tutti i thread in attesa (wait) e il thread
        //    X puo' proseguire, altrimenti si rimette a "dormire".
        notifyAll();
        
        // Q: Vantaggi e svantaggi di notify() e notifyAll() ?
        // A: notifyAll() evita il possibile problema del deadlock, ovvero che il
        //    thread che effettivamente sarebbe da risvegliare rimane a dormire
        //    per sempre perche' lo scheduler del SO e/o la JVM non lo "svegliano".
        //    notify() invece mitiga il problema del "thundering herd problem"
        //    (il problema della mandria in panico), cioe' dove tutti i thread si
        //    "svegliano" solo per scoprire che si devono rimettere a "dormire".
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
