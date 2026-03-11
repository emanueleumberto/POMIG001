package org.example.gestionepizzeriajpa.configurations;

import com.github.javafaker.Faker;
import org.example.gestionepizzeriajpa.models.Cliente;
import org.example.gestionepizzeriajpa.models.Menu;
import org.example.gestionepizzeriajpa.models.Ordine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class OrdineConfiguration {

    // Cliente Bean
    @Bean("creaCliente")
    @Scope("prototype")
    public Cliente creaCliente() {
        return new Cliente();
    }

    @Bean("creaClienteFake")
    @Scope("prototype")
    public Cliente creaClienteFake() {
        Faker fake = new Faker(new Locale("it-IT"));
        Cliente cliente = new Cliente();
        cliente.setNome(fake.name().fullName());
        cliente.setTelefono(fake.phoneNumber().phoneNumber());
        return cliente;
    }

    // Ordine Bean
    @Bean("creaOrdine")
    @Scope("prototype")
    public Ordine creaOrdine() {
        return new Ordine();
    }

}
