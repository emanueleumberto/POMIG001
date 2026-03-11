package org.example.gestionepizzeriajpa.repositories;

import org.example.gestionepizzeriajpa.models.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottiDAORepository extends JpaRepository<Prodotto, Long> {
}
