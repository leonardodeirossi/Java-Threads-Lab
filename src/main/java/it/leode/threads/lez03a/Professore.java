package it.leode.threads.lez03a;

public class Professore {
    private final String nome;
    private final String cognome;

    private int contatoreAppello;
    
    public Professore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        
        this.contatoreAppello = 0;
    }
    
    public synchronized void presente() {
        this.contatoreAppello++;
        System.out.println("Appello: studenti presenti " + this.contatoreAppello);
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getContatoreAppello() {
        return contatoreAppello;
    }

    @Override
    public String toString() {
        return "Professore{" + "nome=" + nome + ", cognome=" + cognome + '}';
    }
}
