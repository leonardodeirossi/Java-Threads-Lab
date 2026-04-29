package it.leode.threads.lez03b;

public class Lavoratore implements Runnable {
    private final Stampante stampante;
    private final int id;
    
    public Lavoratore(Stampante stampante, int id) {
        this.stampante = stampante;
        this.id = id;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Lavoratore #" + this.getId() + " in attesa...");
            this.getStampante().getSemaforo().acquire();
            
            System.out.println("Lavoratore #" + this.getId() + " sta stampando...");
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Lavoratore #" + this.getId() + " ha finito di stampare.");
            this.getStampante().getSemaforo().release();
        }
    }
    
    public Stampante getStampante() {
        return this.stampante;
    }
    
    public int getId() {
        return this.id;
    }
}
