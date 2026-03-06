package org.example.eserciziosettimana4.runners;

import org.example.eserciziosettimana4.classes.Menu;
import org.example.eserciziosettimana4.configurations.PizzeriaConfig;
import org.example.eserciziosettimana4.services.MenuService;
import org.example.eserciziosettimana4.services.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PizzeriaRunner implements CommandLineRunner {

    @Autowired MenuService menuService;
    @Autowired OrdineService ordineService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Pizzeria App...");

        Menu menu = menuService.creaMenu("Pizzeria da Peppe");
        menu.stampaMenu();

        System.out.println("---------------------------------------------------------");

        String ordine1 = ordineService.creaOrdine(
                ordineService.creaCliente("Mario Rossi", "321.654.987"),
                List.of(menuService.creaPizzaMargherita(),
                        menuService.creaDrinkCocaCola(),
                        menuService.creaPizzaBoscaiola(),
                        menuService.creaDrinkBirra()));

        String ordine2 = ordineService.creaOrdine(
                ordineService.creaClienteFake(),
                List.of(menuService.creaPizzaCustom("Pizza Olive", 6.5, List.of("Pomodoro", "Olive", "Capperi")),
                        menuService.creaPizzaMargherita(),
                        menuService.creaPizzaDiavola(),
                        menuService.creaDrinkCocaCola(),
                        menuService.creaDrinkCocaCola(),
                        menuService.creaDrinkAcqua()));

        System.out.println(ordine1);
        System.out.println(ordine2);

        System.out.println("---------------------------------------------------------");

        ordineService.stampaOrdini();
    }
}
