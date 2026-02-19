package Esercizio;

public class Cliente {

    private String nome;
    private String cognome;
    private String citta;
    private int anni;

    public Cliente(String nome, String cognome, String citta, int anni) {
        this.nome = nome;
        this.cognome = cognome;
        this.citta = citta;
        this.anni = anni;
    }

    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getCitta() {
        return citta;
    }
    public int getAnni() {
        return anni;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.cognome + " (" + this.citta +") anni: " + this.anni;
    }
}
