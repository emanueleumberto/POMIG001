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

    }
}