package Esercizio.classes;

import Esercizio.exception.PostiTerminatiException;
import Esercizio.exception.PostoGiaOccupatoException;
import Esercizio.exception.PostoNonValidoException;

public class Teatro {

    private String nome;
    private Utente[] posti;

    public Teatro(String nome, int numPosti) {
        this.nome = nome;
        this.posti = new Utente[numPosti];
    }

    public String getNome() {
        return nome;
    }

    public Utente[] getPosti() {
        return posti;
    }

    public void resetPosti() {
        for (int i = 0; i < this.posti.length; i++) {
            this.posti[i] = null;
        }
        System.out.println("Teatro libero!");
    }

    public void prenotaPosto(int numeroPosto, Utente u) throws PostoNonValidoException, PostoGiaOccupatoException, PostiTerminatiException {

        // Controllo Teatro pieno
        if(!postiDisponibili()){
            throw new PostiTerminatiException("Sold Out!!!");
        }

        // Controllo prenotazione posto fuori range
        if(numeroPosto <= 0 || numeroPosto -1 > this.getPosti().length) {
            throw new PostoNonValidoException("Valore " + numeroPosto + " non valido, devi inserire un valore compreso tra 1 e " + this.getPosti().length);
        }

        // Controllo su posti occupati
        if(this.posti[numeroPosto-1] != null) {
            throw new PostoGiaOccupatoException("Posto " + numeroPosto + " occupato!!!");
        }

        posti[numeroPosto-1] = u;
        System.out.println("Prenotazione posto " + numeroPosto + " effettuato da " + u);
    }

    public boolean postiDisponibili() {
        for (int i = 0; i < this.posti.length; i++) {
            if(posti[i] == null) {
                return true;
            }
        }
        return false;
    }
}
