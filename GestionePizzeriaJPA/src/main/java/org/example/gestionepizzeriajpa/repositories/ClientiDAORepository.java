package org.example.gestionepizzeriajpa.repositories;

import org.example.gestionepizzeriajpa.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientiDAORepository extends JpaRepository<Cliente, Long> {
}
