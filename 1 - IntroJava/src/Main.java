import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Commenti a riga singola
        // ctrl + / -> Commenti a riga singola

        /*
        Commento
        multi
        riga
        */
        // ctrl + shift + / -> Commenti multi riga

        /**
         * Commento con notazione JavaDOC
         */

        // sout -> System.out.println();
        // serr -> System.err.println();
        System.out.println("Ciao a tutti");
        System.err.println("Errore!!!");

        // Classi -> Pascal-case -> Prima lettera maiuscola e poi ogni ulteriore parola con l'iniziale maiuscola (IntroJava)
        // Interfacce -> Pascal-case -> Prima lettera maiuscola e poi ogni ulteriore parola con l'iniziale maiuscola (IntroJava)
        // Metodi -> Camel-case -> Prima lettera minuscola e poi ogni ulteriore parola con l'iniziale maiuscola (metodoIntroJava)
        // Variabili -> Camel-case -> Prima lettera minuscola e poi ogni ulteriore parola con l'iniziale maiuscola (variabileIntroJava)
        // Package -> Snake-case -> Prima lettera minuscola e poi ogni ulteriore parola è collegata da un underscore (intro_java)
        // Costanti -> Snake-case -> Tutto maiuscolo e ogni ulteriore parola è collegata da un underscore (INTRO_JAVA)

        // Linguaggi debolmente tipizzati
        // Javascript -> let x = 25 (type(x) - Number)  -> x = true (type(x) - Boolean)
        // Python -> x = 25 (type(x) - Number)  -> x = true (type(x) - Boolean)
        // Php -> $x = 25 (type(x) - Number)  -> $x = true (type(x) - Boolean)

        // Java è un linguaggio FORTEMENTE tipizzato
        int x = 25;
        x = 10;
        // x = "ciao"; -> Errore!

        // Una variabile in Java è una locazione di memoria in grado di memorizzare un dato
        // tipo nome = valore

        // Tipi di dato prinitivi in JAVA
        // boolean      -> 1  bit
        // char         -> 16 bit
        // byte         -> 8  bit
        // short        -> 16 bit
        // int          -> 32 bit (default)
        // long         -> 64 bit
        // float        -> 32 bit
        // double       -> 64 bit (default)

        boolean b = true;
        char c = 'C';
        short sh = 25;
        int i = 25;
        long l = 25;
        double d = 25.5;
        float f = 25.5f;

        int v; // Dichiarazione di una variabile
        v = 10; // Inizializzazione di una variabile

        int num1, num2, num3;

        // Definire una costante in java
        final int NOME_CONST = 10;

        // Variabile di tipo String
        String s = new String("Ciao a tutti");
        String str = "Ciao a tutti";
        String numStr = "35";

        int n1Int = sh; // Conversione (cast) implicita | piccolo -> grande
        int n2Int = (int) l; // Conversione (cast) esplicita | grande -> piccolo
        int n3Int = (int) d; // Conversione (cast) esplicita | grande double -> piccolo int
        // int n4Int = b; // ERRORE | boolean -> int
        int n5Int = Integer.parseInt(numStr); // Conversione (parse) esplicita tra dati di tipo String e Int
        double nDouble = Double.parseDouble(numStr); // Conversione (parse) esplicita tra dati di tipo String e Double
        long nLong = Long.parseLong(numStr); // Conversione (parse) esplicita tra dati di tipo String e Long

        // Tipo di dato String
        String st = new String("Ciao a tutti");
        st = " Ciao a TUTTI! ";
        System.out.println("Length: " + st.length());
        System.out.println("Empty: " + st.isEmpty());
        System.out.println("UpperCase: " + st.toUpperCase());
        System.out.println("LowerCase: " + st.toLowerCase());
        System.out.println("Trim: " + st.trim());
        System.out.println("Repeat: " + st.repeat(3));
        System.out.println("Replace: " + st.replace('a', '-'));
        System.out.println("Equals: " + st.equals("Ciao a TUTTI!"));
        System.out.println("IndexOf '!': " + st.indexOf("!"));
        System.out.println("CharAt '13': " + st.charAt(13));

        // Operatori
        // Operatore di assegnamento
        //  =

        // Operatori aritmetici
        //  + - * / %

        int n1 = 10;
        int n2 = 3;

        int r = n1/n2;
        int resto = n1%n2;
        System.out.println("Divisione intero: " + r + " con resto di: " + resto);

        double rd = (double) n1/n2;
        System.out.println("Divisione double: " + rd );

        // Operatori aritmetici di assegnamento
        //  += -= *= /= %=
        int nn = 10;
        nn = nn + 3;
        nn += 3;

        // Operatori unari di pre o post incremento e pre o post decremento
        nn = nn + 1;
        nn += 1;
        nn++;
        nn--;

        int x1 = 25;
        //int x2 = x1++; // 26 | 25
        //int x2 = x1--; // 24 | 25
        //int x2 = ++x1; // 26 | 26
        int x2 = --x1; // 24 | 24
        System.out.println(x1 + " | " + x2);

        // Operatori relazionali
        // Restituiscono sempre un valore booleano (true | false)
        //  == != > < >= <=

        int g = 25;
        int n = 10;
        System.out.println("25 uguale a 10: " + (g == n));
        System.out.println("25 diverso da 10: " + (g != n));
        System.out.println("25 maggiore di 10: " + (g > n));
        System.out.println("25 minore di 10: " + (g < n));

        // Operatori logici
        // && || ! ^

        // condizione1 && condizione2 --> true && true --> true
        // condizione1 && condizione2 --> true && false --> false
        // condizione1 && condizione2 --> false && true --> false
        // condizione1 && condizione2 --> false && false --> false

        // condizione1 || condizione2 --> true || true --> true
        // condizione1 || condizione2 --> true || false --> true
        // condizione1 || condizione2 --> false || true --> true
        // condizione1 || condizione2 --> false || false --> false

        // condizione1 ^ condizione2 --> true ^ true --> false
        // condizione1 ^ condizione2 --> true ^ false --> true
        // condizione1 ^ condizione2 --> false ^ true --> true
        // condizione1 ^ condizione2 --> false ^ false --> false

        // !true --> false
        // !false --> true

        // Scanner -> per interagire con l'utente nel terminale
        // Creo un oggetto capace di leggere da terminale valori inseriti da un utente
        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Inserisci il tuo nome: ");
//        String nome = sc.nextLine();
//        System.out.print("Inserisci la tua età: ");
//        // int eta = sc.nextInt(); // Problematico
//        int eta = Integer.parseInt(sc.nextLine());
//        System.out.print("Inserisci la tua città: ");
//        String citta = sc.nextLine();
//
//        System.out.println("Ciao " + nome + "(" + citta + ") età: " + eta);

        // Metodi di una classe
        // modificatori tipoDiRitorno nomeMetodo(tipoParametro nomeParametro) {
        // blocco di istruzioni }
        //test();
        //String utente = testString();
        //System.out.println(utente.toUpperCase());
        //boolean res = testArgs(50);
        // System.out.println(res);

        // Array in Java
        // Un array è un tipo di dato che aggrega più valori nella stessa locazione di memoria
        // in un array posso accedere a gli elementi interni utilizzando l'indice
        // in un array memorizziamo i valori dall'indice 0 a n-1
        // [  0      1      2        3         4    ]
        // ["uno", "due", "tre", "quattro", "cinque"]
        String[] arr = new String[5];
        arr[0] = "uno";
        arr[1] = "due";
        arr[2] = "tre";
        //arr[3] = null;
        arr[4] = "cinque";

        System.out.println(arr[1]);
        System.out.println(arr[3]);

        int[] nums = {1,2,3,4,5};

        System.out.println(nums[1]);
        System.out.println(nums[3]);

        // Algoritmi, strutture di controllo e strutture iterative
        // IF-ELSE | SWITCH | FOR | WHILE | DO WHILE

        // IF-ELSE
        // if(condizione) { blocco di istruzioni)
        // else if (condizione) { blocco di istruzioni)
        // ...
        // else { blocco di istruzioni }
        int numx = 27;
        if(numx > 18) {
            System.out.println("x > 18");
            if(numx % 2 == 0) {
                System.out.println("Numero pari");
            } else {
                System.out.println("Numero dispari");
            }
        } else if(numx == 18) {
            System.out.println("x = 18");
        } else if(numx < 0) {
            System.out.println("Valore errato!!!");
        } else {
            System.out.println("x < 18");
        }

        // SWITCH
        // switch (espressione)
        // case n: blocco di istruzioni; break;
        // ....
        // case n: blocco di istruzioni; break;
        // default: blocco di istruzioni; break;
        System.out.print("Scegli una opzione tra 1-5: ");
        int o = 2; // Integer.parseInt(sc.nextLine());
        switch (o) {
            case 1: System.out.println("Uno");break;
            case 2: System.out.println("Due");break;
            case 3: System.out.println("Tre");break;
            case 4: System.out.println("Quattro");break;
            case 5: System.out.println("Cinque");break;
            default: System.out.println("Valore errato!");break;
        }

        // FOR
        // for(inizializzazione; condizione; incremento) { blocco di istruzioni }
        for(int id=0; id<10; id++) {
            if(id == 2) { continue; }
            if(id == 5) { break; }
            if(id % 2 == 0) { System.out.println(id); }
        }


        // WHILE
        // while(condizione) { blocco di istruzioni }
        int idw = 0;
        while(idw<10) {
            //if(idw == 2) { continue; }
            if(idw == 5) { break; }
            if(idw % 2 == 0) { System.out.println(idw); }
            idw++;
        }

        while (true) {
            System.out.print("Scegli una opzione tra 1-5 oppure 0 per terminare: ");
            int op = Integer.parseInt(sc.nextLine());
            if(op > 0 && op <= 5) {
                System.out.println("Il valore inserito è: " + op);
            } else if(op == 0) {
                break;
            } else {
                System.out.println("Il valore " + op + " è errato!!!");
            }
        }

        // DO-WHILE
        // do { blocco di istruzioni } while(condizione)
        int iddw = 10;
        do {
            System.out.println("Il valore è: " + iddw);
            iddw++;
        } while (iddw < 5);

        // Oggetto LocalDate
        // LocalDate.now() -> restituisce la data del momento
        // LocalDate.of(anno, mese, giorno) -> imposta una data
        LocalDate oggi = LocalDate.now();
        LocalDate altraData = LocalDate.of(2020, 8, 25);
        System.out.println(oggi);
        System.out.println(altraData);
        System.out.println(oggi.getYear());
        System.out.println(oggi.getMonth());
        System.out.println(oggi.getMonthValue());
        System.out.println(oggi.getDayOfMonth());
        System.out.println(oggi.getDayOfWeek());

        // Classi in Java
        Test t1 = new Test("Mario", "Utente");
        //t1.nome = "Mario";
        //t1.tipo = "Utente";
        t1.info();

        Test t2 = new Test("Bobby", "Cane");
        //t2.nome = "Bobby";
        //t2.tipo = "Cane";
        t2.info();
    }

    public static void test() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci il tuo nome: ");
        String nome = sc.nextLine();
        System.out.print("Inserisci la tua età: ");
        // int eta = sc.nextInt(); // Problematico
        int eta = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci la tua città: ");
        String citta = sc.nextLine();

        System.out.println("Ciao " + nome + "(" + citta + ") età: " + eta);
    }

    public static String testString() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci il tuo nome: ");
        String nome = sc.nextLine();
        System.out.print("Inserisci la tua età: ");
        // int eta = sc.nextInt(); // Problematico
        int eta = Integer.parseInt(sc.nextLine());
        System.out.print("Inserisci la tua città: ");
        String citta = sc.nextLine();
        return  "Ciao " + nome + "(" + citta + ") età: " + eta;
    }

    public static boolean testArgs(int age) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci la tua età: ");
        int eta = Integer.parseInt(sc.nextLine());

        return  eta > age;
    }

}
