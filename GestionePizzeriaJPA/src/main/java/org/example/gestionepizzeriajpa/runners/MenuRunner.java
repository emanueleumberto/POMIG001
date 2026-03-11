package org.example.gestionepizzeriajpa.runners;

import org.example.gestionepizzeriajpa.models.Drink;
import org.example.gestionepizzeriajpa.models.Menu;
import org.example.gestionepizzeriajpa.models.Pizza;
import org.example.gestionepizzeriajpa.models.Prodotto;
import org.example.gestionepizzeriajpa.services.MenuService;
import org.example.gestionepizzeriajpa.services.ProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuRunner implements CommandLineRunner {

    @Autowired MenuService menuService;
    @Autowired ProdottiService  prodottiService;

    @Override
    public void run(String... args) throws Exception {

        // Menu
//        Menu menu = menuService.creaMenu("Pizzeria da Peppe");
//        menuService.salvaMenu(menu);

//        Menu menu = menuService.leggiMenu(1);
//        menuService.stampaMenu(menu);

//        menu.setNome("Pizzeria da Peppe e figli");
//        menuService.salvaMenu(menu);

//        menuService.eliminaMenu(menu);

        // Prodotti
//        prodottiService.salvaProdotto(prodottiService.creaPizza("Pizza Margherita", 6.00, List.of("Pomodoro", "Mozzarella"), menu));
//        prodottiService.salvaProdotto(prodottiService.creaPizza("Pizza Boscaiola", 8.00, List.of("Mozzarella", "Funghi", "Salsiccia"), menu));
//        prodottiService.salvaProdotto(prodottiService.creaPizza("Pizza Diavola", 7.00, List.of("Pomodoro", "Mozzarella", "Salame piccante"), menu));
//
//        prodottiService.salvaProdotto(prodottiService.creaDrink("Coca Cola", 3.00, 0, menu));
//        prodottiService.salvaProdotto(prodottiService.creaDrink("Birra", 5.00, 6, menu));
//        prodottiService.salvaProdotto(prodottiService.creaDrink("Acqua", 2.00, 0, menu));

//        Pizza p = (Pizza) prodottiService.leggiProdotto(2);
//        System.out.println("Id prodotto: " + p.getId());
//        System.out.println("Nome prodotto: " + p.getNome());
//        System.out.println("Prezzo prodotto: " + p.getPrezzo());
//        System.out.println("Numero Ingredienti: " + p.getIngredienti().size());
//        System.out.println("Funghi: " + p.getIngredienti().contains("Funghi"));
//        System.out.println("Ingrediente principale: " + p.getIngredienti().get(0));
//        System.out.println("Nome Menu: " + p.getMenu().getNome());
//
//        p.setPrezzo(p.getPrezzo() + (p.getPrezzo()*0.2));
//        prodottiService.salvaProdotto(p);

//        prodottiService.eliminaProdotto(p);


    }
}
