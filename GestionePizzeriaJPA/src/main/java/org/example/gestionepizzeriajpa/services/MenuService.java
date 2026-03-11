package org.example.gestionepizzeriajpa.services;

import org.example.gestionepizzeriajpa.models.Drink;
import org.example.gestionepizzeriajpa.models.Menu;
import org.example.gestionepizzeriajpa.models.Pizza;
import org.example.gestionepizzeriajpa.repositories.MenuDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired @Qualifier("creaMenu") ObjectProvider<Menu> creaMenuObjectProvider;
    @Autowired MenuDAORepository menuDB;

    public Menu creaMenu(String nomeMenu) {
        return Menu.builder().nome(nomeMenu).build();
    }

    public void stampaMenu(Menu menu) {
        System.out.println("************* Menu " + menu.getNome() + " **************");
        System.out.println("----- Pizze -----");
        menu.getListaProdotto().forEach(prodotto -> {
            if(prodotto instanceof Pizza){
                System.out.println(prodotto);
            }
        });
        System.out.println("----- Drink -----");
        menu.getListaProdotto().forEach(prodotto -> {
            if(prodotto instanceof Drink){
                System.out.println(prodotto);
            }
        });

    }

    public void salvaMenu(Menu menu) {
        menuDB.save(menu);
        System.out.println("Menu: " + menu.getNome() + " salvato nel DB!");
    }

    public Menu leggiMenu(long id) {
        return menuDB.findById(id).get();
    }

    public void eliminaMenu(Menu menu) {
        menuDB.delete(menu);
    }
}
