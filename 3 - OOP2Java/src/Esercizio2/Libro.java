package Esercizio2;

public class Libro {

    private String titolo;
    private String autore;
    private String ISBN;
    private boolean disponibile;

    public Libro(String titolo, String autore, String ISBN) {
        this.titolo = titolo;
        this.autore = autore;
        this.ISBN = ISBN;
        this.disponibile = true;
    }

    public String getTitolo() {
        return titolo;
    }
    public String getAutore() {
        return autore;
    }
    public String getISBN() {
        return ISBN;
    }
    public boolean isDisponibile() {
        return disponibile;
    }

    public String getDettagli() {
        // → Restituisce una stringa con i dettagli del libro
        return "Libro: " + this.titolo + " Autore: " + this.autore + " ISBN: " + this.ISBN + " Disponibile: " + this.disponibile;
    }

    public void prestareLibro() {
        // → Imposta disponibile = false se il libro è disponibile,
        // altrimenti stampa libro non disponibile
        if(this.disponibile) {
            this.disponibile = false;
        } else {
            System.out.println("Libro " + this.titolo + " non disponibile!");
        }
    }

    public void restituireLibro() {
        // → Imposta disponibile = true se il libro era in prestito,
        // altrimenti stampa un Errore
        if(!this.disponibile) {
            this.disponibile = true;
        } else {
            System.err.println("Attenzione non è possibile restituire " + this.titolo);
        }
    }

}
