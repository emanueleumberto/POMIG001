package org.example.eserciziosettimana4.configurations;

import com.github.javafaker.Faker;
import org.example.eserciziosettimana4.classes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Locale;

@Configuration
public class PizzeriaConfig {

    // Menu Bean
    @Bean("menu")
    @Scope("singleton")
    public Menu creaMenu() {
        return new Menu();
    }

    // Pizza Bean
    @Bean("pizzaMargherita")
    @Scope("singleton")
    public Pizza creaPizzaMargherita() {
        return new Pizza("Pizza Margherita", 6.00, List.of("Pomodoro", "Mozzarella"));
    }

    @Bean("pizzaBoscaiola")
    @Scope("singleton")
    public Pizza creaPizzaBoscaiola() {
        return new Pizza("Pizza Boscaiola", 8.00, List.of("Mozzarella", "Funghi", "Salsiccia"));
    }

    @Bean("pizzaDiavola")
    @Scope("singleton")
    public Pizza creaPizzaDiavola() {
        return new Pizza("Pizza Diavola", 7.00, List.of("Pomodoro", "Mozzarella", "Salame piccante"));
    }

    @Bean("pizzaCustom")
    @Scope("prototype")
    public Pizza creaPizzaCustom(String nome, Double prezzo, List<String> ingredienti) {
        return new Pizza(nome, prezzo, ingredienti);
    }

    @Bean("pizzaBase")
    @Scope("prototype")
    public Pizza creaPizza() {
        return new Pizza();
    }

    // Drink Bean
    @Bean("drinkCocaCola")
    @Scope("singleton")
    public Drink creaDrinkCocaCola() {
        return new Drink("Coca Cola", 3.00, 0);
    }

    @Bean("drinkBirra")
    @Scope("singleton")
    public Drink creaDrinkBirra() {
        return new Drink("Birra", 5.00, 6);
    }

    @Bean("drinkAcqua")
    @Scope("singleton")
    public Drink creaDrinkAcqua() {
        return new Drink("Acqua", 2.00, 0);
    }

    @Bean("drinkCustom")
    @Scope("prototype")
    public Drink creaDrinkCustom(String nome, Double prezzo, Integer gradi) {
        return new Drink(nome, prezzo, gradi);
    }

    @Bean("drinkBase")
    @Scope("prototype")
    public Drink creaDrink() {
        return new Drink();
    }

    // Cliente Bean
    @Bean("clienteCustom")
    @Scope("prototype")
    public Cliente creaCliente() {
        return new Cliente();
    }

    @Bean("clienteFake")
    @Scope("prototype")
    public Cliente creaClienteFake() {
        Faker fake = new Faker(new Locale("it-IT"));
        return new Cliente(fake.name().fullName(), fake.phoneNumber().cellPhone());
    }

    // Ordine Bean
    @Bean("ordine")
    @Scope("prototype")
    public Ordine creaOrdine() {
        return new Ordine();
    }
}
