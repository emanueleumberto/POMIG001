package Esercizio;

import java.time.LocalDate;
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

        // conctena(somma(), moltiplica(), sottrai(), dividi());

        System.out.println("*************************************************************");

        // Esercizio 5 - Strutture di controllo e strutture iterative

        // boolean b = stringaPariDispari();
        // System.out.println("Numero di caratteri pari: " + b);
        // boolean bis = annoBisestile();
        // System.out.println("Anno bisestile: " + bis);

        stampaMese(LocalDate.now());
        stampaStagione(LocalDate.of(2025,3,25));

        // suddividiStringa(inserisciStringa());

        // contoAllaRovescia();
        popolaArray();
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

    public static boolean stringaPariDispari() {
        //stringaPariDispari  -> Chiede ad un utente una stringa, ritorna true se il numero dei caratteri
        //è pari altrimenti deve ritornare false
        System.out.print("Inserisci una stringa: ");
        String str = sc.nextLine();
        //return str.length() % 2 == 0;
        if(str.length() % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean annoBisestile() {
//        annoBisestile -> Chiede ad un utente un anno, ritorna true se è un anno bisestile
//        altrimenti deve ritornare false
//        (Per essere un anno bisestile deve essere divisibile per 4,
//                qualora sia divisibile per 100 deve essere anche divisibile per 400)

        System.out.print("Inserisci anno: ");
        int anno = Integer.parseInt(sc.nextLine());
        if(anno % 400 == 0) {
            return true;
        } else if(anno % 4 == 0 && anno % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void stampaMese(LocalDate obj) {
        // stampaMese -> passare un oggetto di tipo LocalDate come paramentro del metodo e stampare a video
        //                            la data completa nel seguente formato (11 - Febbraio - 2025)

        //System.out.println(obj);
        int day = obj.getDayOfMonth();
        String month = obj.getMonth().toString();
        int year = obj.getYear();

        switch (month) {
            case "FEBRUARY": month = "Febbraio"; break;
            case "MARCH": month = "Marzo"; break;
            default: month = "----"; break;
        }

        System.out.println(day + " - " + month + " - " + year);
    }

    public static void stampaStagione(LocalDate obj) {
        //stampaStagione -> passare un oggetto di tipo LocalDate come paramentro del metodo
        // e stampare a video la stagione corrispondente
        switch (obj.getMonthValue()) {
            case 12,1,2:
                System.out.println("Inverno");
                break;
            case 3,4,5:
                System.out.println("Primavera");
                break;
            case 6,7,8:
                System.out.println("Estate");
                break;
            case 9,10,11:
                System.out.println("Autunno");
                break;
            default:
                System.out.println("Errore!!");
                break;
        }
    }

    public static String inserisciStringa() {
        // inserisciStringa -> Scrivere un metodo che chiede di inserire una stringa e ne controlla la lunghezza.
        //                            deve ripetere la richiesta di inserimento della stringa fin quando la lunghezza
        //                            non è almeno di 5 caratteri. Infine si deve ritornare la stringa inserita.

        // Soluzione con ciclo while
//        while(true) {
//            System.out.print("Inserisci una stringa: ");
//            String str = sc.nextLine();
//            if (str.length() > 5) {
//                return str;
//            }
//            System.out.println("Devi inserire una stringa lunga alemno 5 caratteri.");
//        }

        // Soluzione con ciclo do-while
        String str;
        do {
            System.out.print("Inserisci una stringa: ");
            str = sc.nextLine();
        } while (str.length() < 5);
        return str;
    }

    public static void suddividiStringa(String str) {
        // suddividiStringa -> Scrivere un metodo che riceve come paramentro una stringa, si deve suddividere
        //    in caratteri separati da una virgola e stampare a video.  ("s,t,r,i,n,g,a")

        // Soluzione con split()
//        String[] strSplit = str.split("");
//        String testo = "";
//        int i = 0;
//        while(i < strSplit.length) {
//            //System.out.println(strSplit[i]);
//            if(i == strSplit.length-1) {
//                testo += strSplit[i];
//            } else {
//                testo += strSplit[i] + ",";
//            }
//            i++;
//        }

        // Soluzione con charAt()
        String testo = "";
        int i = 0;
        while(i < str.length()) {
            if(i == str.length()-1) {
                testo += str.charAt(i);
            } else {
                testo += str.charAt(i) + ",";
            }
            i++;
       }
        System.out.println(testo);
    }

    public static void contoAllaRovescia() {
        // -   contoAllaRovescia -> Scrivere un metodo che chieda di inserire un numero valido(0->100), altrimenti richiedere il valore.
        //                            Infine stampi il conto alla rovescia dal numero valido inserito fino a zero.
        int num;
        do {
            System.out.print("Inserisci un numero valido(0-100): ");
            num = Integer.parseInt(sc.nextLine());
        } while (num < 0 || num > 100);
        for (int i = num; i >= 0; i--) {
            System.out.println(i + " -> " + num);
        }
    }

    public static void popolaArray() {
        // popolaArray -> Scrivere un metodo che chiede di inserire la lunghezza di un array, in base al
        //                            valore fornito dall'utente creare un array di Stringhe e popolarlo con il metodo
        //                            inserisciStringa creato in precedenza. Infine stampare le stringhe contenute
        //                            nell'array tramite il metodo suddividiStringa.
        System.out.print("Inserisci un numero valido(1-20): ");
        int num = Integer.parseInt(sc.nextLine());
        // Creo un array di String con lunghezza pari al valore inserito da terminale dall'utente
        String[] arr = new String[num];
        // Itero completamente l'array e lo popolo con strighe create tramite il metodo inserisciStringa()
        for (int i = 0; i < arr.length; i++) {
            arr[i] = inserisciStringa();
        }
        // Stampo i valori inseriti nell'array tramite il metodo suddividiStringa()
        for (int i = 0; i < arr.length; i++) {
            suddividiStringa(arr[i]);
        }
    }
}
