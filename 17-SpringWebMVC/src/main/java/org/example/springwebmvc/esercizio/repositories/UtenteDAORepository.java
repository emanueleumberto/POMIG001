package org.example.springwebmvc.esercizio.repositories;

import org.example.springwebmvc.esercizio.models.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteDAORepository extends JpaRepository<Utente, Long> {
    public Utente findByEmail(String email);
}
