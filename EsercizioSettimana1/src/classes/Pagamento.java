package classes;

import exception.PagamentoException;

public abstract class Pagamento {

    private String idTransazione;
    private double importo;
    protected boolean completato;

    public Pagamento(String idTransazione, double importo) {

        if(idTransazione == null || idTransazione.isBlank()) {
            throw new IllegalArgumentException("ID transazione non valida!");
        }

        if(importo <= 0) {
            throw new IllegalArgumentException("Importo non valido!");
        }

        this.idTransazione = idTransazione;
        this.importo = importo;
        this.completato = false;
    }

    public String getIdTransazione() {
        return idTransazione;
    }
    public double getImporto() {
        return importo;
    }
    public boolean isCompletato() {
        return completato;
    }

    public abstract void eseguiPagamento() throws PagamentoException;

    public void stampaDettagli() {
        System.out.println("ID: " + this.idTransazione +
                           " - Importo €" + this.importo +
                           " | Completato: " + this.completato);
    }
 }
