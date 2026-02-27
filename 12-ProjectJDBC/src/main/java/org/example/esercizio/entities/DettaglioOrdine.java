package org.example.esercizio.entities;

public class DettaglioOrdine {

    private int idDettaglioOrdine;
    private Prodotto prodotto;
    private int quantita;
    private double prezzoUnitario;

    public DettaglioOrdine(Prodotto prodotto, int quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.prezzoUnitario = prodotto.getPrezzo();
    }

    public DettaglioOrdine(int idDettaglioOrdine, Prodotto prodotto, int quantita, double prezzoUnitario) {
        this.idDettaglioOrdine = idDettaglioOrdine;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }

    public int getIdDettaglioOrdine() {
        return idDettaglioOrdine;
    }
    public Prodotto getProdotto() {
        return prodotto;
    }
    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }
    public int getQuantita() {
        return quantita;
    }
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }
    public void setPrezzoUnitario(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    @Override
    public String toString() {
        return idDettaglioOrdine + " - prodotto: " + prodotto + ", qt: " + quantita + ", €" + prezzoUnitario;
    }
}
