package model;

public class User {

    private static int count = 1;
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String username;
    private String password;

    public User(String nome, String cognome, String email, String username, String password) {
        this.id = count++;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.username = username;
        this.password = password;
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
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "id: " + id + " - " + nome + " " + cognome + " email: " + email + " username: " + username + " password: " + password ;
    }
}
