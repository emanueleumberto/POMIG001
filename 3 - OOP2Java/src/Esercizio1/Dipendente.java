package Esercizio1;

public class Dipendente {

    private static int count = 1;
    private String matricola ;
    private String nomeCompleto;
    private double stipendioBase;
    private double stipendio;
    private Dipartimento dipartimento;

    public Dipendente(String nomeCompleto, Dipartimento dipartimento) {
        this.matricola =  count < 10 ? "D00" + count++ : "D0" + count++;
        this.nomeCompleto = nomeCompleto;
        this.dipartimento = dipartimento;
        this.stipendioBase = 1200.00;
        this.stipendio = calcolaStipendio();
    }

    private double calcolaStipendio() {
        if(this.dipartimento.equals(Dipartimento.PRODUZIONE)) {
            return this.stipendioBase + (this.stipendioBase * 0.2);
        } else if(this.dipartimento.equals(Dipartimento.VENDITE)) {
            return this.stipendioBase + (this.stipendioBase * 0.3);
        } else if(this.dipartimento.equals(Dipartimento.AMMINISTRAZIONE)) {
            return this.stipendioBase + (this.stipendioBase * 0.4);
        } else {
            return this.stipendioBase;
        }
    }


    public String getMatricola() {
        return matricola;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public double getStipendioBase() {
        return stipendioBase;
    }
    public double getStipendio() {
        return stipendio;
    }
    public Dipartimento getDipartimento() {
        return dipartimento;
    }
    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
        this.stipendio = calcolaStipendio();
    }

    public String info() {
        return getMatricola() + " - " + getNomeCompleto() + " (" + this.dipartimento + ") €" + this.stipendio;
    }
}
