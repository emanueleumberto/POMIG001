package Esercizio;

public class GestioneCorso {
    public static void main(String[] args) {

        // Dichiarazione array di tipo Studente
        Studente[] studenti = new Studente[5];

        // Popolo un array con oggetti di tipo Studente
        studenti[0] = new Studente("Mario", "Rossi", 25, 24.7);
        studenti[1] = new Studente("Giuseppe", "Verdi", 23, 17.9);
        studenti[2] = new Studente("Francesca", "Neri", 21, 29.4);

        // Eseguo i metodi definiti
        System.out.println("Iscritti al corso: ");
        stampaUtenti(studenti);
        double media = calcolaMedia(studenti);
        System.out.println("Media voti del corso: " + media);
        System.out.println("Elenco studenti promossi (voto medio >= 18): ");
        leggiPromossi(studenti);

    }

    public static void stampaUtenti(Studente[] studenti) {
        // Stampa tutti gli studenti
        for (int i = 0; i < studenti.length; i++) {
            if(studenti[i] != null) {
                studenti[i].stampaDati();
                stampaValutazione(studenti[i].votoMedio);
            }
        }
    }

    public static double calcolaMedia(Studente[] studenti) {
        // Calcola la media dei voti del corso
        double sommaVoti = 0;
        int contatore = 0;
        int index = 0;
        while(index < studenti.length) {
            if(studenti[index] != null) {
                sommaVoti += studenti[index].votoMedio;
                contatore++;
            }
            index++;
        }
        return sommaVoti/contatore;
    }

    public static void leggiPromossi(Studente[] studenti) {
        for (int i = 0; i < studenti.length; i++) {
            if(studenti[i] != null && studenti[i].votoMedio >= 18) {
                studenti[i].stampaDati();
            }
        }
    }

    public static void stampaValutazione(double votoMedio) {
        int fascia = 0;
        if(votoMedio < 18) {
            // -> voto < 18 → "Insufficiente"
            fascia = 0;
        } else if(votoMedio < 24) {
            // -> 18 <= voto < 24 → "Sufficiente"
            fascia = 1;
        } else if(votoMedio < 28) {
            // -> 24 <= voto < 28 → "Buono"
            fascia = 2;
        } else {
            // -> voto >= 28 → "Ottimo"
            fascia = 3;
        }

        switch (fascia) {
            case 0:
                System.out.println("   Valutazione: Insufficiente");
                break;
            case 1:
                System.out.println("   Valutazione: Sufficiente");
                break;
            case 2:
                System.out.println("   Valutazione: Buono");
                break;
            case 3:
                System.out.println("   Valutazione: Ottimo");
                break;
        }
    }
}
