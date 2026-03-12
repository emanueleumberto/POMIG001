package org.example.springwebmvc.esercizio.services;

import org.example.springwebmvc.esercizio.models.Utente;
import org.example.springwebmvc.esercizio.repositories.UtenteDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired  @Qualifier("creautente") ObjectProvider<Utente> utenteObjectProvider;
    @Autowired  @Qualifier("creaadmin") ObjectProvider<Utente> adminObjectProvider;
    @Autowired UtenteDAORepository db;

    public Utente creaUtente(String nome, String email, String password) {
        Utente utente = utenteObjectProvider.getObject();
        utente.setNome(nome);
        utente.setEmail(email);
        utente.setPassword(password);
        utente.setRuolo("USER");
        return utente;
    }

    public Utente creaAdmin() {
        return adminObjectProvider.getObject();
    }

    public Utente salvaUtente(Utente utente) {
        db.save(utente);
        return utente;
    }

    public Utente leggiUtente(long id) {
        return db.findById(id).orElse(null);
    }

    public void eliminaUtente(Utente utente) {
        db.delete(utente);
    }

    public List<Utente> leggiUtenti() {
        return db.findAll();
    }

    public Utente registerUser(String name, String email, String password) {

        if(checkEmail(email)){
            throw new RuntimeException("Email already exists");
        }

        return salvaUtente(creaUtente(name, email, password));
    }

    public Utente authenticateUser(String email, String password) {
        Utente utente = db.findByEmail(email);
        if(utente != null && utente.getPassword().equals(password)){
            return utente;
        }
        return null;
    }

    @Override
    public boolean checkEmail(String email) {
        return db.findByEmail(email) != null;
    }
}
