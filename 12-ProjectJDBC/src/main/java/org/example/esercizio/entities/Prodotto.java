package org.example.esercizio.entities;

public class Prodotto {

    private int idProdotto;
    private String nome;
    private String descrizione;
    private  double prezzo;
    private int quantitaDisponibile;

    public Prodotto(String nome, String descrizione, double prezzo, int quantitaDisponibile) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public Prodotto(int idProdotto, String nome, String descrizione, double prezzo, int quantitaDisponibile) {
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public int getIdProdotto() {
        return idProdotto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public int getQuantitaDisponibile() {
        return quantitaDisponibile;
    }
    public void setQuantitaDisponibile(int quantitaDisponibile) {
        this.quantitaDisponibile = quantitaDisponibile;
    }

    @Override
    public String toString() {
        return idProdotto + " - " + nome + " (" + descrizione + ") € " + prezzo + " [" + quantitaDisponibile + "]";
    }
}
