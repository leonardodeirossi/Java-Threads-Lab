package it.leode.threads.lez03;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        Stampante stampante = new Stampante();
        
        for (int i = 1; i < 4; i++) {
            Thread t = new Thread(new Lavoratore(stampante, i));
            t.start();
        }
    }
}
