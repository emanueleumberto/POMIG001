package org.example.gestionepizzeriajpa.services;

import org.example.gestionepizzeriajpa.models.Drink;
import org.example.gestionepizzeriajpa.models.Menu;
import org.example.gestionepizzeriajpa.models.Pizza;
import org.example.gestionepizzeriajpa.models.Prodotto;
import org.example.gestionepizzeriajpa.repositories.ProdottiDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottiService {

    @Autowired @Qualifier("creaPizza") ObjectProvider<Pizza> creaPizzaObjectProvider;
    @Autowired @Qualifier("creaDrink") ObjectProvider<Drink> creaDrinkObjectProvider;
    @Autowired ProdottiDAORepository prodottiDB;

    public Pizza creaPizza(String nomePizza, double prezzo, List<String> ingredienti, Menu menu) {
        return Pizza
                .builder()
                .nome(nomePizza)
                .prezzo(prezzo)
                .menu(menu)
                .ingredienti(ingredienti)
                .build();
    }
    public Drink creaDrink(String nomeDrink, double prezzo, int gradi, Menu menu) {
        return Drink
                .builder()
                .nome(nomeDrink)
                .prezzo(prezzo)
                .gradi(gradi)
                .menu(menu)
                .build();
    }

    public void salvaProdotto(Prodotto prodotto) {
        prodottiDB.save(prodotto);
        System.out.println("Prodotto: " + prodotto.getNome() + " salvato nel DB!");
    }

    public Prodotto leggiProdotto(long id) {
        return prodottiDB.findById(id).get();
    }

    public void eliminaProdotto(Prodotto prodotto) {
        prodottiDB.delete(prodotto);
        System.out.println("Prodotto: " + prodotto.getNome() + " elimianto dal DB!");
    }
}
