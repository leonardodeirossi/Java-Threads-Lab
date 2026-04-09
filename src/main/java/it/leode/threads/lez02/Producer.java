package it.leode.threads.lez02;

public class Producer implements Runnable {

    private Buffer buffer;

    // Q: che tipo di passaggio viene fatto per buffer?
    //
    // A: in Java quando si passa come parametro un oggetto avviene un passaggio "particolare",
    //    ovvero viene passato il "valore di un riferimento". Ciò significa che da un lato
    //    non viene creata una nuova copia (quindi il buffer in questo caso e' condiviso)
    //    ma dall'altro a differenza dei puntatori in C la ri-assegnazione (es con new)
    //    va a modificare solo la "copia" locale.
    //
    // A (di Gemini): in Java passi il valore del riferimento, il che ti permette di modificare
    //                il contenuto della "scatola" (l'oggetto), ma non di scambiare la "scatola"
    //                stessa con un'altra dall'esterno del metodo.
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            this.buffer.produce(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                // ---
            }
        }
    }

    /*
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            this.buffer.produce(i);
        }
    }
     */
}
