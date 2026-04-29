package it.leode.threads.lez03a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        Professore deirossi = new Professore("Leonardo Essam", "Dei Rossi");
        
        System.out.println(deirossi.toString());
        
        int numeroStudenti;
        System.out.print("Inserisci il numero di studenti: ");
        numeroStudenti = io.nextInt();
        
        for (int i = 0; i < numeroStudenti; i++) {
            Studente stud = new Studente("Studente #" + numeroStudenti, deirossi);
            stud.start();
        }
    }
}
