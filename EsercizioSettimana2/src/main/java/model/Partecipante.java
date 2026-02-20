package model;

public class Partecipante {

    private static int counter = 1;
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String tipoBiglietto;

    public Partecipante(String nome, String cognome, String email, String tipoBiglietto) {
        this.id = counter++;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.tipoBiglietto = tipoBiglietto;
    }

    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getEmail() {
        return email;
    }
    public String getTipoBiglietto() {
        return tipoBiglietto;
    }

    @Override
    public String toString() {
        // formato per il salvataggio su file
        // (Mario,Rossi,mario@email.it,VIP)
        return id + "," + nome + "," + cognome + "," + email + "," + tipoBiglietto ;
    }
}
