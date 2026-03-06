package org.example.eserciziosettimana4.classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Drink extends Prodotto {

    private Integer gradi;

    public Drink(String nome, Double prezzo, Integer gradi) {
        super(nome, prezzo);
        this.gradi = gradi;
    }

    @Override
    public String toString() {
        return " - " + super.toString() + " gradi: " + gradi;
    }

}
