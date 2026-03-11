package org.example.springjpa.models.ereditarieta.runners;

import org.example.springjpa.models.ereditarieta.models.Moto;
import org.example.springjpa.models.ereditarieta.models.Veicolo;
import org.example.springjpa.models.ereditarieta.services.VeicoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class VeicoloRunner implements CommandLineRunner {

    @Autowired VeicoloService  veicoloService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("VeicoloRunner start");

        Veicolo auto = veicoloService.creaAutomobile("Fiat", "Panda", "AB123CD", 3);
        Veicolo moto = veicoloService.creaMoto("Honda", "Hornet", "BD456SA", 1);
        Veicolo camp = veicoloService.creaCamper("Laika", "Camping", "DC789XZ", 5);

//         veicoloService.saveVeicolo(auto);
//         veicoloService.saveVeicolo(moto);
//         veicoloService.saveVeicolo(camp);

//         Veicolo veicolo = veicoloService.findVeicolo(2);
//         System.out.println(veicolo);

//         Moto m = (Moto) veicolo;
//         m.setNumPosti(2);
//         veicoloService.saveVeicolo(m);

//         veicoloService.removeVeicolo(veicolo);

//         veicoloService.findAllVeicolo().forEach(System.out::println);
    }
}
