package org.example.springjpa.models.ereditarieta.configurations;

import org.example.springjpa.models.ereditarieta.models.Automobile;
import org.example.springjpa.models.ereditarieta.models.Camper;
import org.example.springjpa.models.ereditarieta.models.Moto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class VeicoloConfiguration {

    @Bean("creaAutomobile")
    @Scope("prototype")
    public Automobile creaAutomobile() {
        return new Automobile();
    }

    @Bean("creaMoto")
    @Scope("prototype")
    public Moto creaMoto() {
        return new Moto();
    }

    @Bean("creaCamper")
    @Scope("prototype")
    public Camper creaCamper() {
        return new Camper();
    }

}
