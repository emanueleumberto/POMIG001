package org.example.springwebmvc.esercizio.configurations;

import org.example.springwebmvc.esercizio.models.Utente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UtenteConfiguration {

    @Bean("creautente")
    @Scope("prototype")
    public Utente creaUtente() {
        return new Utente();
    }

    @Bean("creaadmin")
    @Scope("singleton")
    public Utente creaAdmin() {

        return Utente.builder()
                .nome("Mario Rossi")
                .email("m.rossi@example.com")
                .password("Pa$$w0rd!")
                .ruolo("ADMIN")
                .build();
    }

}
