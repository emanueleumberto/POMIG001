package com.example.spring_intro.esercizio.runners;

import com.example.spring_intro.esercizio.classes.Menu;
import com.example.spring_intro.esercizio.configurations.PizzeriaConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(3)
public class PizzeriaRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Pizzeria App...");

        // Creo un Application Context dove gestire il ciclo di vita di un bean
        // creato tramite una classe di configurazione PizzeriaConfig
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaConfig.class);

        Menu menu = (Menu) context.getBean("creaMenu");
        //System.out.println(menu);
        menu.stampaMenu();

        context.close();
    }
}
