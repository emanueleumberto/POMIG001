package org.example.gestionepizzeriajpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Entity
@DiscriminatorValue("drink")
public class Drink extends Prodotto{

    @Column(name = "degrees")
    private Integer gradi;

    @Override
    public String toString() {
        return " - " + super.toString() + " gradi: " + gradi;
    }

}
