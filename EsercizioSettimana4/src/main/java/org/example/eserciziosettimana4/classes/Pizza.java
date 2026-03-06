package org.example.eserciziosettimana4.classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Pizza extends Prodotto {

    private List<String> ingredienti = new ArrayList<String>();

    public Pizza(String nome, Double prezzo, List<String> ingredienti) {
        super(nome, prezzo);
        this.ingredienti = ingredienti;
    }

    @Override
    public String toString() {
        return " - " + super.toString() + " ingredienti: " + ingredienti;
    }

}
