package org.example.gestionepizzeriajpa.repositories;

import org.example.gestionepizzeriajpa.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDAORepository extends JpaRepository<Menu, Long> {
}
