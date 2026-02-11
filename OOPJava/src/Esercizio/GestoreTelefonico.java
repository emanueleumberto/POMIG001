package Esercizio;

public class GestoreTelefonico {
    public static void main(String[] args) {
        Sim s1 = new Sim("+39 987.654.321");

        Chiamata c1 = new Chiamata(3, "+39 123.456.789");
        Chiamata c2 = new Chiamata(1, "+39 654.456.123");
        Chiamata c3 = new Chiamata(7, "+39 741.258.963");

        s1.stampaSim();
        s1.ricaricaCredito(5);
        s1.effettuaChiamata(c1);
        s1.effettuaChiamata(c2);
        s1.effettuaChiamata(c3);
        s1.stampaSim();
    }
}
