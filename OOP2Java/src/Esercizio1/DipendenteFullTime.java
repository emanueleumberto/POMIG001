package Esercizio1;

public class DipendenteFullTime extends Dipendente{
    public DipendenteFullTime(String nomeCompleto, Dipartimento dipartimento) {
        super(nomeCompleto, dipartimento);
    }

    public double calculateSalary() {
        return getStipendio();
    }

    public String info() {
        return getMatricola() + " - " + getNomeCompleto() + " (" + this.getDipartimento() + ") €" + calculateSalary() + " - " + this.getClass().getSimpleName();
    }
}
