package Esercizio;

public class Dirigente  extends Dipendente{
    public Dirigente(String nomeCompleto, Dipartimento dipartimento) {
        super(nomeCompleto, dipartimento);
    }

    public double calculateSalary() {
        return getStipendio() * 2;
    }

    public String info() {
        return getMatricola() + " - " + getNomeCompleto() + " (" + this.getDipartimento() + ") €" + calculateSalary() + " - " + this.getClass().getSimpleName();
    }
}
