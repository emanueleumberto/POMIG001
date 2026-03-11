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
public class Camper extends Veicolo {

    @Column(name = "numero_letti", nullable = true)
    private Integer numLetti;

    @Override
    public String toString() {
        return "Camper - " + super.toString()+ " numLetti=" + numLetti;
    }
}
