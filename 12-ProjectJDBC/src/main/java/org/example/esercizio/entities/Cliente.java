package org.example.esercizio.entities;

public class Cliente {

    private int idCliente;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;

    public Cliente(String nome, String cognome, String email, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
    }
    public Cliente(int idCliente, String nome, String cognome, String email, String telefono) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return idCliente + " - " + nome + " " +  cognome + ", email: " + email + ", tel. " + telefono;
    }
}
