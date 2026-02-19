package Esercizio2;

public class Utente {

    private static int count = 1;
    private String nome;
    private String cognome;
    private String IDUtente;
    private Libro[] listaPrestiti;

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.IDUtente = count < 10 ? "U000" + count++ : "U00" + count++;
        this.listaPrestiti = new Libro[3];
    }

    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getIDUtente() {
        return IDUtente;
    }
    public Libro[] getListaPrestiti() {
        return listaPrestiti;
    }

    public boolean prendereInPrestito(Libro libro) {
        // → Aggiunge il libro alla lista e aggiorna la disponibilità
        if(libro.isDisponibile()) { // Controllo se il libro è disponibile
            for (int i = 0; i < this.listaPrestiti.length; i++) {
                // Controllo se l'utente ha la possibilità di prendere in prestito almeno un libro
                if(this.listaPrestiti[i] == null) {
                    libro.prestareLibro(); // imposto la proprietà disponibile su false
                    this.listaPrestiti[i] = libro; // inserisco il libro nella lista prestiti personali
                    return true; // esco dal metodo a differenza del break che esce solo dal ciclo for e continia con il resto delle istruzioni
                }
            }
            System.out.println("Hai già 3 libri in prestito, restituisci qualcosa per poter prendere in prestito un nuovo libro!");
        } else {
            System.out.println("Libro " + libro.getTitolo() + " non disponibile, torna tra qualche giorno!");
        }
        return false;
    }

    public boolean restituireLibro(Libro libro) {
        // → Rimuove il libro dalla lista e aggiorna la disponibilità
        for (int i = 0; i < listaPrestiti.length; i++) {
            if(listaPrestiti[i] != null && listaPrestiti[i].getISBN().equals(libro.getISBN())) {
                libro.restituireLibro();
                this.listaPrestiti[i] = null;
                return true;
            }
        }
        System.out.println("Il libro che vuoi restituire non è a te assegnato!!");
        return false;
    }

    public void mostraLibriInPrestito(){
        // → Stampa i libri presi in prestito dall'utente
        System.out.println("Libri in prestito da " + this.nome + " " + this.cognome);
        for (int i = 0; i < this.listaPrestiti.length; i++) {
            if(listaPrestiti[i] != null) {
                System.out.println("   - " + listaPrestiti[i].getTitolo());
            } else {
                System.out.println("   - " + listaPrestiti[i]);
            }
        }
    }

}



