package org.example.springwebmvc.esercizio.services;

import org.example.springwebmvc.esercizio.models.Utente;

import java.util.List;

public interface UtenteService {

    public Utente creaUtente(String nome, String email, String password);
    public Utente creaAdmin();
    public Utente salvaUtente(Utente utente);
    public Utente leggiUtente(long id);
    public void eliminaUtente(Utente utente);
    public List<Utente> leggiUtenti();
    public Utente registerUser(String name, String email, String password);
    public Utente authenticateUser(String email, String password);
    public boolean checkEmail(String email);

}
