public class Main {
    public static void main(String[] args) {
        Automobile a1 = new Automobile("Fiat", "Panda", 1000, "Rosso", TipoAlimentazione.BENZINA);
//        a1.marca = "Fiat";
//        a1.modello = "Panda";
//        a1.targa = "AB123CD";
//        a1.colore = "Rosso";
//        a1.cilindrata = 1000;
//        a1.alimentazione = "Benzina";

        Automobile a2 = new Automobile("Ford", "Fiesta", 1200, "Nero", TipoAlimentazione.DIESEL, "AB123CD");
        Automobile a3 = new Automobile("Renault", "Clio", 1400, "Bianco", TipoAlimentazione.GPL);

        a1.info();
        a2.info();

        Automobile.conteggioAutoProdotte();

    }
}