package Esercizio;

import java.util.List;

public class Ordine {

    private static int count = 1;
    private int id;
    private Cliente cliente;
    private List<Prodotto> listaProdotti;

    public Ordine(Cliente cliente, List<Prodotto> listaProdotti) {
        this.id = count++;
        this.cliente = cliente;
        this.listaProdotti = listaProdotti;
    }

    public int getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    // Metodo per il calcolo del totale dell'ordine
    public double getTotaleOrdine() {
        return listaProdotti.stream()
                    .mapToDouble(Prodotto::getPrezzo)
                    .sum();
    }

    @Override
    public String toString() {
        return "Ordine #"+this.id +
                " Cliente: " + this.cliente +
                " n.Prodotti: " + listaProdotti.size() +
                " Totale: " + getTotaleOrdine();
    }
}
