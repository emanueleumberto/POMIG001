package org.example.gestionepizzeriajpa.configurations;

import org.example.gestionepizzeriajpa.models.Drink;
import org.example.gestionepizzeriajpa.models.Menu;
import org.example.gestionepizzeriajpa.models.Pizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MenuConfiguration {

    // Menu Bean
    @Bean("creaMenu")
    @Scope("singleton")
    public Menu creaMenu() {
        return new Menu();
    }

    // Pizza Bean
    @Bean("creaPizza")
    @Scope("prototype")
    public Pizza creaPizza() {
        return new Pizza();
    }

    // Drink Bean
    @Bean("creaDrink")
    @Scope("prototype")
    public Drink creaDrink() {
        return new Drink();
    }

}
