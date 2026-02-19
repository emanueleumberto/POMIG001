package Esercizio;

import Esercizio.classes.Donna;
import Esercizio.classes.Teatro;
import Esercizio.classes.Uomo;
import Esercizio.exception.PostiTerminatiException;
import Esercizio.exception.PostoGiaOccupatoException;
import Esercizio.exception.PostoNonValidoException;

public class GestioneTeatro {
    public static void main(String[] args) {
        Teatro t = new Teatro("MioTeatro", 50);

        Uomo u = new Uomo("Mario", "Rossi", "RRORSS123RT963ES");
        Donna d = new Donna("Francesca", "Neri", "FRSNRI123PL345KJ");
        Uomo g = new Uomo("Giuseppe", "Verdi", "GPPVRD546RD123TX");


        try {
            t.prenotaPosto(3, u);
            t.prenotaPosto(30, d);
            t.prenotaPosto(49, g);
        } catch (PostoNonValidoException | PostoGiaOccupatoException | PostiTerminatiException e) {
            System.err.println(e.getMessage());
        }

        t.resetPosti();
    }
}
