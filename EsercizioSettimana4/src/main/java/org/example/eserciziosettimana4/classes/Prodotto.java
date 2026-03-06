package org.example.eserciziosettimana4.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Prodotto {

    private String nome;
    private Double prezzo;

    @Override
    public String toString() {
        return nome + ", prezzo: €" + prezzo;
    }
}
