package org.example.springwebmvc.esercizio.runners;

import org.example.springwebmvc.esercizio.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UtenteRunner implements CommandLineRunner {

    @Autowired UtenteService utenteService;

    @Override
    public void run(String... args) throws Exception {
        if(utenteService.leggiUtenti().isEmpty()){
            utenteService.salvaUtente(utenteService.creaAdmin());
        }
    }
}
