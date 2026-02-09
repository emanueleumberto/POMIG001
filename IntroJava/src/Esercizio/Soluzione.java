package Esercizio;

import java.util.Scanner;

public class Soluzione {

    public static Scanner sc = new Scanner(System.in);


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

        //int numeroInteroErrato = Integer.parseInt(valoreErrato); // Errore di tipo NumberFormatException

        System.out.println("*************************************************************");

        // Esercizio 4 - Metodi e operatori
//        int miaSomma = somma();
//        int miaMoltipicazione = moltiplica();
//        int miaSottrazione = sottrai();
//        double miaDivisione = dividi();
//        conctena(miaSomma, miaMoltipicazione, miaSottrazione, miaDivisione);

        conctena(somma(), moltiplica(), sottrai(), dividi());
    }

    public static int somma() {
        // somma -> Chiede ad un utente due numeri, li somma e ne restituisce il risultato
        System.out.print("Inserisci un numero: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci un secondo numero: ");
        int num2 = Integer.parseInt(sc.nextLine());
        return num1 + num2;
    }

    public static int moltiplica() {
        // moltiplica -> Chiede ad un utente due numeri, li moltiplica e ne restituisce il risultato
        System.out.print("Inserisci un numero: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci un secondo numero: ");
        int num2 = Integer.parseInt(sc.nextLine());
        return num1 * num2;
    }

    public static int sottrai() {
        // sottrai -> Chiede ad un utente due numeri, li sottrae e ne restituisce il risultato
        System.out.print("Inserisci un numero: ");
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci un secondo numero: ");
        int num2 = Integer.parseInt(sc.nextLine());
        return num1 - num2;
    }

    public static double dividi() {
        // dividi -> Chiede ad un utente due numeri, li divide e ne restituisce il risultato
        System.out.print("Inserisci un numero: ");
        double num1 = Double.parseDouble(sc.nextLine());
        System.out.print("Inserisci un secondo numero: ");
        double num2 = Double.parseDouble(sc.nextLine());
        if(num2 == 0){
            return 0;
        } else {
            return num1 / num2;
        }
    }

    public static void conctena(int somma, int moltiplica, int sottrai, double dividi) {
        // concatena   -> Prende in ingresso 4 valori (somma, moltiplica, sottrai, dividi) e stampa nel terminale
        //                    una stringa con tutti i valori calcolati dai metodi precedenti
        System.out.println("Risultati dei metodi precedenti: ");
        System.out.println("     - Somma: " + somma);
        System.out.println("     - Moltiplicazione: " + moltiplica);
        System.out.println("     - Sottrazione: " + sottrai);
        System.out.println("     - Divisione: " + dividi);
    }
}
