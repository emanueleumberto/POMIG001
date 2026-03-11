package org.example.springjpa.models.ereditarieta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Automobile extends Veicolo {

    @Column(name = "numero_porte", nullable = true)
    private Integer numPorte;

    @Override
    public String toString() {
        return "Automobile - " + super.toString() + " numPorte=" + numPorte;
    }
}
