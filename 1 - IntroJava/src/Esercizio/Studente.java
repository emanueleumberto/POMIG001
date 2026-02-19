package Esercizio;

public class Studente {

    public String nome;
    public String cognome;
    public int eta;
    public double votoMedio;

    public Studente(String nome, String cognome, int eta, double votoMedio) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.votoMedio = votoMedio;
    }

    public void stampaDati() {
        System.out.println(" - " + this.nome + " " + this.cognome
                         + " eta: " + this.eta
                         + " VotoMedio: " + this.votoMedio);
    }

}
