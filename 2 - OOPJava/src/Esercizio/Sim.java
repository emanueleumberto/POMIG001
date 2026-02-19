package Esercizio;

public class Sim {

    public String numeroTelefono;
    public double creditoDisponibile;
    public Chiamata[] listaChiamate;

    public Sim(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
        this.creditoDisponibile = 0;
        this.listaChiamate = new Chiamata[5];
    }

    public void stampaSim() {
        System.out.println("Sim numero: " + this.numeroTelefono);
        System.out.println("Credito disponibile: " + this.creditoDisponibile);
        System.out.println("Lista chiamate: ");
        for (int i = 0; i < listaChiamate.length; i++) {
            if(listaChiamate[i] != null) {
                System.out.println("  - " + listaChiamate[i].numeroChiamato + "(" + listaChiamate[i].durata + ")");
            } else {
                System.out.println("  - ");
            }
        }
    }

    public void ricaricaCredito(double credito) {
        this.creditoDisponibile += credito;
        System.out.println("Ricarica da €"+ credito + " effettuata sul numero " + this.numeroTelefono);
    }

    public void effettuaChiamata(Chiamata chiamata) {
        if(this.creditoDisponibile > 0) {
            System.out.println("Chiamata effettuata sul numero " + chiamata.numeroChiamato + " durata: " + chiamata.durata + " minuti");
            aggiornaCredito(chiamata.durata);
            salvaChiamata(chiamata);
        } else {
            System.out.println("Non hai credito sufficiente!!");
        }
    }

    public void aggiornaCredito(double minuti) {
        double importoSpeso = 0.2 * minuti;
        this.creditoDisponibile -= importoSpeso;
    }

    public void salvaChiamata(Chiamata chiamata) {
        for (int i = 0; i < this.listaChiamate.length; i++) {
            if(this.listaChiamate[i] == null) {
                this.listaChiamate[i] = chiamata;
                break;
            }
        }
    }

}
