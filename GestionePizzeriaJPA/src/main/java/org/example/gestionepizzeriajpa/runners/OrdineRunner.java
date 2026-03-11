package org.example.gestionepizzeriajpa.runners;

import org.example.gestionepizzeriajpa.models.Cliente;
import org.example.gestionepizzeriajpa.models.Drink;
import org.example.gestionepizzeriajpa.models.Ordine;
import org.example.gestionepizzeriajpa.models.Pizza;
import org.example.gestionepizzeriajpa.services.ClientiService;
import org.example.gestionepizzeriajpa.services.OrdineService;
import org.example.gestionepizzeriajpa.services.ProdottiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdineRunner implements CommandLineRunner {

    @Autowired ClientiService  clientiService;
    @Autowired OrdineService ordineService;
    @Autowired ProdottiService prodottiService;

    @Override
    public void run(String... args) throws Exception {

        // Clienti
//        Cliente marioRossi = clientiService.creaCliente("Mario Rossi", "+39 123.456.789");
//        Cliente fake = clientiService.creaClienteFake();
//
//        clientiService.salvaCliente(marioRossi);
//        clientiService.salvaCliente(fake);

        Cliente cliente = clientiService.leggiCliente(2);
//        System.out.println("Cliente: " + cliente);

//        cliente.setTelefono("+39 987.654.321");
//        clientiService.salvaCliente(cliente);

        clientiService.eliminaCliente(cliente);

        // Prodotti
//        Pizza margherita = (Pizza) prodottiService.leggiProdotto(1);
//        Pizza diavola = (Pizza) prodottiService.leggiProdotto(3);
//        Drink cocacola = (Drink) prodottiService.leggiProdotto(4);
//        Drink birra = (Drink) prodottiService.leggiProdotto(5);


        // Ordine

//        Ordine ordine = ordineService.creaOrdine(cliente, List.of(margherita, diavola, cocacola, birra));
//        ordineService.salvaOrdine(ordine);

//        Ordine ordine = ordineService.leggiOrdine(1);
//        ordineService.stampaOrdine(ordine);

//        Drink acqua = (Drink) prodottiService.leggiProdotto(6);
//        ordine.getProdottiOrdinati().add(acqua);
//        ordineService.salvaOrdine(ordine);

//        ordineService.eliminaOrdine(ordine);

    }
}
