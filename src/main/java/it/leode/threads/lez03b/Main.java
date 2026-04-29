package it.leode.threads.lez03b;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        int numeroLavoratori;
        
        System.out.print("Inserisci il numero di lavoratori: ");
        numeroLavoratori = io.nextInt();
        
        if (numeroLavoratori > 0) {
            Stampante stampante = new Stampante();
            
            for (int i = 1; i <= numeroLavoratori; i++) {
                Thread t = new Thread(new Lavoratore(stampante, i));
                t.start();
            }
        } else {
            System.out.println("Errore: numero di lavoratori non valido!");
        }
    }

    /*
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        Stampante stampante = new Stampante();
        
        for (int i = 1; i < 4; i++) {
            Thread t = new Thread(new Lavoratore(stampante, i));
            t.start();
        }
    }
     */
}
