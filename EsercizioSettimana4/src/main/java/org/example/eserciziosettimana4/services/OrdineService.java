package org.example.eserciziosettimana4.services;

import org.example.eserciziosettimana4.classes.*;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdineService {

    private static int numOrdine = 1;
    private List<Ordine> ordini = new ArrayList<Ordine>();

    @Autowired @Qualifier("clienteCustom") ObjectProvider<Cliente> clienteCustom;
    @Autowired @Qualifier("clienteFake") ObjectProvider<Cliente> clienteFake;
    @Autowired @Qualifier("ordine") ObjectProvider<Ordine> ordineBase;

    public Cliente creaClienteFake() { return clienteFake.getObject() ; }

    public Cliente creaCliente(String nome, String telefono) {
        Cliente cliente = clienteCustom.getObject();
        cliente.setNome(nome);
        cliente.setTelefono(telefono);
        return cliente;
    }

    public String creaOrdine(Cliente cliente, List<Prodotto> prodottiOrdinati) {
        Ordine ordine = ordineBase.getObject();
        ordine.setNumeroOrdine(numOrdine++);
        ordine.setCliente(cliente);
        ordine.setProdottiOrdinati(prodottiOrdinati);
        ordine.setDataOrdine(LocalDate.now());
        ordini.add(ordine);

        double totale = ordine.getProdottiOrdinati().stream().mapToDouble(Prodotto::getPrezzo).sum();
        return "Ordine n." + ordine.getNumeroOrdine() + " di " + ordine.getCliente().getNome() + " totale €" + totale;
    }

    public void stampaOrdini() {
        ordini.forEach(ordine -> {
            System.out.println("Ordine n." + ordine.getNumeroOrdine());
            System.out.println("Data: " + ordine.getDataOrdine());
            System.out.println("Cliente: " + ordine.getCliente().getNome());

            System.out.println("Lista pizze ordinate:");
            ordine.getProdottiOrdinati().forEach(prodotto -> {
                if(prodotto instanceof Pizza) {
                    System.out.println("   - " + prodotto.getNome() + " - €" + prodotto.getPrezzo());
                }
            });

            System.out.println("Lista drink ordinati:");
            ordine.getProdottiOrdinati().forEach(prodotto -> {
                if(prodotto instanceof Drink) {
                    System.out.println("   - " + prodotto.getNome() + " - €" + prodotto.getPrezzo());
                }
            });

            double totale = ordine.getProdottiOrdinati().stream().mapToDouble(Prodotto::getPrezzo).sum();
            System.out.println("Totale ordine: €" + totale);
        });
    }

}
