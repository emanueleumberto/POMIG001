package Esercizio.model;

public class Cliente {

    private static int count = 1;
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private String citta;

    public Cliente(String nome, String cognome, String email, String telefono, String citta) {
        this.id = count++;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.citta = citta;
    }

    public Cliente(int id, String nome, String cognome, String email, String telefono, String citta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
        this.citta = citta;
    }

    public int getId() {
        return id;
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
    public String getTelefono() {
        return telefono;
    }
    public String getCitta() {
        return citta;
    }

    public String toFileString() {
        return this.id+","+this.nome+","+this.cognome+","+this.citta+","+this.email+","+this.telefono+System.lineSeparator();
    }

    @Override
    public String toString() {
        return id + " - " + nome + " " + cognome + " (" + citta + ") email: " + email + " Tel." + telefono;
    }
}
