package org.example.esercizio.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Ordine {

    private int idOrdine;
    private Cliente cliente;
    private LocalDate data_ordine;
    private List<DettaglioOrdine> dettaglioOrdine;

    public Ordine(Cliente cliente, List<DettaglioOrdine> dettaglioOrdine) {
        this.cliente = cliente;
        this.data_ordine = LocalDate.now();
        this.dettaglioOrdine = dettaglioOrdine;
    }

    public Ordine(int idOrdine, Cliente cliente, LocalDate data_ordine, List<DettaglioOrdine> dettaglioOrdine) {
        this.idOrdine = idOrdine;
        this.cliente = cliente;
        this.data_ordine = data_ordine;
        this.dettaglioOrdine = dettaglioOrdine;
    }

    public int getIdOrdine() {
        return idOrdine;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public LocalDate getData_ordine() {
        return data_ordine;
    }
    public void setData_ordine(LocalDate data_ordine) {
        this.data_ordine = data_ordine;
    }
    public List<DettaglioOrdine> getDettaglioOrdine() {
        return dettaglioOrdine;
    }

    @Override
    public String toString() {
        return idOrdine + " - Cliente: " + cliente + ", data ordine: " + data_ordine + ", dettaglioOrdine: " + dettaglioOrdine.size();
    }
}
