package org.example.gestionepizzeriajpa.services;

import org.example.gestionepizzeriajpa.models.*;
import org.example.gestionepizzeriajpa.repositories.OrdineDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdineService {

    @Autowired @Qualifier("creaOrdine") ObjectProvider<Ordine> creaOrdineObjectProvider;
    @Autowired OrdineDAORepository ordineDB;

    public Ordine creaOrdine(Cliente cliente, List<Prodotto> prodottiOrdinati) {
        Ordine ordine = creaOrdineObjectProvider.getObject();
        ordine.setCliente(cliente);
        ordine.setProdottiOrdinati(prodottiOrdinati);
        ordine.setDataOrdine(LocalDate.now());
        ordine.setTotale(prodottiOrdinati.stream().mapToDouble(Prodotto::getPrezzo).sum());
        return ordine;
    }

    public void stampaOrdine(Ordine ordine) {
        System.out.println("************* Ordine n." + ordine.getNumeroOrdine() + " **************");
        System.out.println("Cliente: " + ordine.getCliente().getNome() + " (" + ordine.getCliente().getTelefono() + ")");
        System.out.println("Data Ordine: " + ordine.getDataOrdine());
        System.out.println("Dettaglio ordine: ");
        System.out.println("----- Pizze -----");
        ordine.getProdottiOrdinati().forEach(prodotto -> {
            if(prodotto instanceof Pizza){
                System.out.println(prodotto);
            }
        });
        System.out.println("----- Drink -----");
        ordine.getProdottiOrdinati().forEach(prodotto -> {
            if(prodotto instanceof Drink){
                System.out.println(prodotto);
            }
        });
        System.out.println("Totale: €" + ordine.getTotale());

    }

    public void salvaOrdine(Ordine ordine) {
        ordineDB.save(ordine);
        System.out.println("Ordine: " + ordine.getNumeroOrdine() + " salvato nel DB!");
    }

    public Ordine leggiOrdine(long numeroOrdine) {
        return ordineDB.findById(numeroOrdine).get();
    }

    public void eliminaOrdine(Ordine ordine) {
        ordineDB.delete(ordine);
    }

}
