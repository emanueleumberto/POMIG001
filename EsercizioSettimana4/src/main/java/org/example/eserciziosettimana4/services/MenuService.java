package org.example.eserciziosettimana4.services;

import org.example.eserciziosettimana4.classes.Drink;
import org.example.eserciziosettimana4.classes.Menu;
import org.example.eserciziosettimana4.classes.Pizza;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired @Qualifier("pizzaMargherita") ObjectProvider<Pizza> pizzaMargherita;
    @Autowired @Qualifier("pizzaBoscaiola") ObjectProvider<Pizza> pizzaBoscaiola;
    @Autowired @Qualifier("pizzaDiavola") ObjectProvider<Pizza> pizzaDiavola;
    @Autowired @Qualifier("pizzaBase") ObjectProvider<Pizza> pizzaBase;
    @Autowired @Qualifier("drinkCocaCola") ObjectProvider<Drink> drinkCocaCola;
    @Autowired @Qualifier("drinkBirra") ObjectProvider<Drink> drinkBirra;
    @Autowired @Qualifier("drinkAcqua") ObjectProvider<Drink> drinkAcqua;
    @Autowired @Qualifier("drinkBase") ObjectProvider<Drink> drinkBase;
    @Autowired @Qualifier("menu") ObjectProvider<Menu> menuBase;

    public Pizza creaPizzaMargherita() { return pizzaMargherita.getObject(); }
    public Pizza creaPizzaBoscaiola() { return pizzaBoscaiola.getObject(); }
    public Pizza creaPizzaDiavola() { return pizzaDiavola.getObject(); }
    public Drink creaDrinkCocaCola() { return drinkCocaCola.getObject(); }
    public Drink creaDrinkBirra() { return drinkBirra.getObject(); }
    public Drink creaDrinkAcqua() { return drinkAcqua.getObject(); }


    public Pizza creaPizzaCustom(String nome, double prezzo, List<String> ingredienti) {
        Pizza pizza = pizzaBase.getObject();
        pizza.setNome(nome);
        pizza.setPrezzo(prezzo);
        pizza.setIngredienti(ingredienti);
        return pizza;
    }

    public Drink creaDrinkCustom(String nome, double prezzo, int gradi) {
        Drink drink = drinkBase.getObject();
        drink.setNome(nome);
        drink.setPrezzo(prezzo);
        drink.setGradi(gradi);
        return drink;
    }

    public Menu creaMenu(String nome) {
        Menu menu = menuBase.getObject();
        menu.setNome(nome);
        menu.getListaProdotto().add(creaPizzaMargherita());
        menu.getListaProdotto().add(creaPizzaBoscaiola());
        menu.getListaProdotto().add(creaPizzaDiavola());
        menu.getListaProdotto().add(creaPizzaCustom("Pizza Olive", 6.5, List.of("Pomodoro", "Olive", "Capperi")));
        menu.getListaProdotto().add(creaDrinkAcqua());
        menu.getListaProdotto().add(creaDrinkBirra());
        menu.getListaProdotto().add(creaDrinkCocaCola());
        menu.getListaProdotto().add(creaDrinkCustom("Spritz", 10.00, 12));
        return menu;
    }

}
