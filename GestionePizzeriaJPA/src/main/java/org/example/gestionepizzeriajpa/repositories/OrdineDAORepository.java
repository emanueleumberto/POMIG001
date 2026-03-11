package org.example.gestionepizzeriajpa.repositories;

import org.example.gestionepizzeriajpa.models.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineDAORepository extends JpaRepository<Ordine, Long> {
}
