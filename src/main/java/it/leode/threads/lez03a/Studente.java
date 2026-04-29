package it.leode.threads.lez03a;

public class Studente extends Thread {
    private final Professore prof;
    
    public Studente(String cognomeNome, Professore prof) {
        super(cognomeNome);
        this.prof = prof;
    }
    
    @Override
    public void run() {
        prof.presente();
        
        /*
        try {
            prof.presente();
            Thread.sleep(1500);
        } catch(InterruptedException ex) {
            System.out.println("[InterruptedException] " + ex.getMessage());
        }
        */
    }
}
