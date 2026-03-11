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
public class Moto extends Veicolo {

    @Column(name = "numero_posti", nullable = true)
    private Integer numPosti;

    @Override
    public String toString() {
        return "Moto - " + super.toString()+ " numPosti=" + numPosti;
    }

}
