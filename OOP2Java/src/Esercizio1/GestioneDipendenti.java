package Esercizio1;

public class GestioneDipendenti {
    public static void main(String[] args) {

        Dipendente[] dipendenti = new Dipendente[6];

        dipendenti[0] = new Dirigente("Antonella Grigi", Dipartimento.AMMINISTRAZIONE);
        dipendenti[1] = new Dirigente("Fulvio Viola", Dipartimento.PRODUZIONE);
        dipendenti[2] = new DipendenteFullTime("Mario Rossi", Dipartimento.PRODUZIONE);
        dipendenti[3] = new DipendentePartTime("Giuseppe Verdi", Dipartimento.VENDITE, 30);
        dipendenti[4] = new DipendentePartTime("Francesca Neri", Dipartimento.AMMINISTRAZIONE, 30);
        dipendenti[5] = new DipendentePartTime("Antonio Bianchi", Dipartimento.VENDITE, 20);

        for (int i = 0; i < dipendenti.length; i++) {
            System.out.println(dipendenti[i].info());
        }

    }
}
