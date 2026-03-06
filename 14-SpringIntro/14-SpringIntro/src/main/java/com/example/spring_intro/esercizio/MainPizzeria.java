package com.example.spring_intro.esercizio;

import com.example.spring_intro.configurations.UserConfiguration;
import com.example.spring_intro.esercizio.classes.Menu;
import com.example.spring_intro.esercizio.configurations.PizzeriaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class MainPizzeria {

    public static void main(String[] args) {
        SpringApplication.run(MainPizzeria.class, args);

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
