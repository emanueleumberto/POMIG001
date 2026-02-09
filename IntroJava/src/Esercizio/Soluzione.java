package Esercizio;

public class Soluzione {
    public static void main(String[] args) {
        // Esercizio 1 – Variabili, tipi primitivi e casting
        int var1 = 10; // 32 bit
        double var2 = 25.55; // 64 bit
        long var3 = 100L; // 64 bit
        float var4 = 12.75f; // 32 bit

        // casting implicito
        double castImplicito1 = var1; // int -> double
        long castImplicito2 = var1; // int -> long

        // casting espliciti
        int castEsplicito1 = (int) var3; // long -> int
        float castEsplicito2 = (float) var2; // double -> float

        System.out.println("Casting implicito (int -> double): " + castImplicito1);
        System.out.println("Casting implicito (int -> long): " + castImplicito2);

        System.out.println("Casting esplicito (long -> int): " + castEsplicito1);
        System.out.println("Casting esplicito (double -> float): " + castEsplicito2);

        System.out.println("*************************************************************");

        // Esercizio 2 – Costanti, String e metodi principali

        final short MAX_LENGTH = 20; // Costante
        String str = " Java Programming ";

        System.out.println("Lunghezza originale della Stringa: " + str.length());
        System.out.println("Stringa originale senza spazi inizio/fine: " + str.trim());
        System.out.println("Stringa originale senza spazi maiuscolo: " + str.trim().toUpperCase());
        System.out.println("Confronto Stringa originale senza spazi con equals: " + str.trim().equals("Java Programming"));

        System.out.println("*************************************************************");

        // Esercizio 3 – Conversione String ↔ numeri e gestione errori

        String valoreNumerico = "25";
        String valoreErrato = "25a";

        int numeroIntero = Integer.parseInt(valoreNumerico);
        double numeroDouble = Double.parseDouble(valoreNumerico);

        System.out.println("Valore intero: " + numeroIntero);
        System.out.println("Valore double: " + numeroDouble);

        int numeroInteroErrato = Integer.parseInt(valoreErrato); // Errore di tipo NumberFormatException

    }
}
