package org.example.springjpa.models.ereditarieta.repositories;

import org.example.springjpa.models.ereditarieta.models.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeicoloDAORepository extends JpaRepository<Veicolo,Long> {

    public boolean existsByTarga(String targa);

}
