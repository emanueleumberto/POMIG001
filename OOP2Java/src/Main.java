import TestModificatori.Test;

public class Main {
    public static void main(String[] args) {
        // In linguaggio OOP si poggia su 4 concetti fondamentali
        // - Incapsulamento
        // - Ereditarietà
        // - Astrazione
        // - Polimorfismo

        // Incapsulamento
        // Modificatori di accesso
        // public | private | protected | package o default

        // Ereditarietà
        Automobile a1 = new Automobile("Fiat", "Panda", "Bianco", 3);
        Automobile a2 = new Automobile("Ford", "Fiesta", "Nero", 5);
        Moto m1 = new Moto("Honda", "Hornet", "Nero", 1);
        Camper c1 = new Camper("Laika", "Camping", "Bianco", 7);
        Moto m2 = new Moto("Ducati", "Monster", "Rosso", 2);
        Smartphone s1 = new Smartphone("Apple", "Iphone17", "Argento", 64);
        Veicolo v1 = new Automobile("Renault", "Captur", "Grigio", 5);
        // Veicolo v2 = new Veicolo("Fiat", "Tipo", "verde"); // Abstract Class

        System.out.println(a1.info());
        System.out.println(m1.info());
        System.out.println(c1.info());
        System.out.println(s1.info());
        // System.out.println(v1.info());

        Veicolo[] veicoli = new Veicolo[6];
        veicoli[0] = a1;
        veicoli[1] = m1;
        veicoli[2] = m2;
        veicoli[3] = c1;
        veicoli[4] = a2;
        veicoli[5] = v1;
        //veicoli[6] = s1;

        for (int i = 0; i < veicoli.length; i++) {
            System.out.println(veicoli[i].info());
//            if(veicoli[i] instanceof Automobile) {
//                Automobile a = (Automobile) veicoli[i];
//                System.out.println(a.info());
//            } else if(veicoli[i] instanceof Moto) {
//                Moto m = (Moto) veicoli[i];
//                System.out.println(m.info());
//            } else if(veicoli[i] instanceof Camper) {
//                Camper c = (Camper) veicoli[i];
//                System.out.println(c.info());
//            } else {
//                System.out.println("????");
//            }

        }

        // Test Modificatori di accesso
        Test t = new Test("public", "package", "protected", "private");
        System.out.println("Public: " + t.var1);
        System.out.println("Private: ");
        System.out.println("Package: ");
        System.out.println("Protected: ");

        TestFiglio tf = new TestFiglio("public", "package", "protected", "private");
        System.out.println("Public: " + tf.var1);
        System.out.println("Private: ");
        System.out.println("Package: ");
        System.out.println("Protected: ");


    }
}