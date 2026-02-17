import generics.Test;
import generics.TestInteger;
import generics.TestString;
import generics.Utente;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Generics
        // I Generics consentono di scrivere Classi, Interfacce, metodi generici, che funzionano con diversi tipi di dati
        // senza dover specificare in anticipo il tipo esatto.
        // Ciò rende il codice più flessibile, riutilizzabile e sicuro

        TestString ts = new TestString("Stringa");
        ts.setVal("Ciao");
        TestInteger ti = new TestInteger(25);
        ti.setVal(30);
        Test<Boolean,Integer> tb = new Test<>(true);
        tb.setVal(false);
        Test<Utente, Character> tu = new Test<>(new Utente());
        tu.setVal(new Utente());


        // Collections
        // Contenitori dinamici di elementi. A differenza degli array che hanno una dimensione fissa.
        // Una collection può essere ordinata o non ordinata, può permettere valori duplicato o no.
        // Una collection è un interfaccia che eredita da Iterable e
        // non specifica nulla di quanto detto sopra (valori ordinati o duplicati)
        // Collection
        // Non memorizza l'ordine in cui sono stati inseriti gli elementi,
        // non definisce se ci possono essere dei valori duplicati o no.
        // non può contenere valori primitivi, ma solo oggetti. Se ho bisogno di utilizzare valori primitivi
        // sono costretto ad utilizzare le classi Wrapper(Integer, Double, Character, Boolean)
        // -> List
        //      Gli elementi sono indicizzati può contenere valori duplicati
        //      I valori sono memorizzati in base all'ordine di inserimento
        //      Consente di leggere, aggiungere, rimuovere e modificare gli elementi in base ad un indice.
        //      La classe principale che implementa l'interfaccia List è ArrayList
        // -> Set
        //      Non ammette valori duplicati ma gli elementi non sono indicizzati
        //      i valori inseriti NON sono memorizzati in base all'indice di inserimento
        //      La classe principale che implementa l'interfaccia Set è HashSet
        //      -> SortedSet
        //          Non ammette valori duplicati ma a differenza di Set gli elementi sono parzialmente ordinati
        //          Posso leggere il primo e/o l'ultimo valore sel set
        //          La classe principale che implementa l'interfaccia SortedSet è TreeSet
        // -> Queue
        //      Crea una coda che ha dei metodi per leggere, inserire ed eliminare elementi da inizio e fine della coda
        //      Gli elementi sono ordinati e può contenere valori duplicati
        //      La classe principale che implementa l'interfaccia Queue è LinkedList
        // Map
        // Definisce una lista di elementi di tipo chiave/valore.
        // non può contenere valori primitivi, ma solo oggetti. Se ho bisogno di utilizzare valori primitivi
        // sono costretto ad utilizzare le classi Wrapper(Integer, Double, Character, Boolean)
        // Una chiave sarà una etichetta univoca della mappa che servirà per accedere ad un valore associato
        // I valori inseriti NON sono memorizzati in base all'ordine di inserimento
        // La classe principale che implementa l'interfaccia Map è HashMap



        // Classi Wrapper
        String s = new String("Sono una stringa"); // Deprecato
        String str = "Sono una stringa";

        int x = 25;
        Integer y = new Integer(25); // Deprecato
        Integer z = 25;
        // System.out.println(y);
        // System.out.println(z);

        // testCollection();
        // testList();
        // testSet();
        // testQueue();
        // testMap();

    }

    public static void testCollection() {
        Collection<String> c = new HashSet();
        c.add("Primo Elemento");
        c.add("Secondo Elemento");
        c.add("Terzo Elemento");
        c.add("Quarto Elemento");

        System.out.println("Collection size: " + c.size());
        System.out.println("Contains element 'Secondo Elemento': " + c.contains("Secondo Elemento"));
        System.out.println("Collection isEmpty: " + c.isEmpty());

        c.remove("Secondo Elemento");

        for (String str : c) {
            System.out.println(str);
        }

//        c.clear();
//        System.out.println("Collection isEmpty: " + c.isEmpty());

        String[] arrStr =  c.toArray(String[]::new);
        System.out.println("Array length: " + arrStr.length);
        for (int i = 0; i < arrStr.length; i++) {
            System.out.println(arrStr[i]);
        }


    }

    public static void testList() {
        List<String> l = new ArrayList<>();

        // Metodi ereditati da Collection
        l.add("Primo Elemento");
        l.add("Secondo Elemento");
        l.add("Terzo Elemento");
        l.add("Quarto Elemento");
        l.add("Secondo Elemento");


        System.out.println("List size: " + l.size());
        System.out.println("Contains element 'Secondo Elemento': " + l.contains("Secondo Elemento"));
        System.out.println("List isEmpty: " + l.isEmpty());

        l.remove("Secondo Elemento");

//        l.clear();
//        System.out.println("List isEmpty: " + l.isEmpty());

        // Metodo di List
        l.add(2, "Nuovo Elemento");
        l.remove(1);

        System.out.println("First element: " + l.getFirst());
        System.out.println("Last element: " + l.getLast());
        System.out.println("Get element index 1: " + l.get(1));

        for (String str : l) {
            System.out.println(str);
        }
    }

    public static void testSet() {
        //Set<String> s = new HashSet<>();
        SortedSet<String> s = new TreeSet<>();

        // Metodi ereditati da Collection
        s.add("Primo Elemento");
        s.add("Secondo Elemento");
        s.add("Terzo Elemento");
        s.add("Quarto Elemento");
        s.add("Secondo Elemento"); // Valore duplicato | Non è stato inserito

        System.out.println("Set size: " + s.size());
        System.out.println("Contains element 'Secondo Elemento': " + s.contains("Secondo Elemento"));
        System.out.println("List isEmpty: " + s.isEmpty());

        s.remove("Secondo Elemento");

        // add()    -> restituisce true se il valore viene inserito correttamente nel set
        //          -> restituisce false quando il valore non viene inserito perchè duplicato
        if(s.add("Quarto Elemento")) {
            System.out.println("Valore inserito nel SET");
        } else {
            System.out.println("'Quarto Elemento' Valore duplicato!!!");
        }

        for (String str : s) {
            System.out.println(str);
        }

        // Metodi di SortedSet
        // Degli elementi NON ORDINATI definiti in un SET leggo il primo e l'ultimo
        System.out.println("First element: " + s.getFirst());
        System.out.println("Last element: " + s.getLast());
    }

    public static void testQueue() {
        Queue<String> q = new LinkedList<>();

        // Metodi ereditati da Collection
        q.add("Primo Elemento");
        q.add("Secondo Elemento");
        q.add("Terzo Elemento");
        q.add("Quarto Elemento");
        q.add("Secondo Elemento");

        System.out.println("Queue size: " + q.size());
        System.out.println("Contains element 'Secondo Elemento': " + q.contains("Secondo Elemento"));
        System.out.println("Queue isEmpty: " + q.isEmpty());

        q.remove("Secondo Elemento");

        // Metodi definiti in Queue
        q.remove(); // Elimina il prima elemento della coda
        System.out.println("First element: " + q.peek()); // Legge il primo elemento della coda
        System.out.println("Find and Remove First element: " + q.poll()); // Legge e rimuove il primo elemento della coda

        for (String str : q) {
            System.out.println(str);
        }

        q.clear();
        System.out.println("Collection isEmpty: " + q.isEmpty());
    }

    public static void testMap() {
        // Map<String, String> m = new HashMap();
        SortedMap<String, String> m = new TreeMap<>();

        m.put("A", "Primo Elemento");
        m.put("B", "Secondo Elemento");
        m.put("C", "Terzo Elemento");

        System.out.println("Map size: " + m.size());
        System.out.println("Map isEmpty: " + m.isEmpty());
        System.out.println("Contains key 'B': " + m.containsKey("B"));
        System.out.println("Contains value 'Secondo Elemento': " + m.containsKey("Secondo Elemento"));
        System.out.println("Get element key 'B': " + m.get("B"));

        m.remove("B");

        Set<String> keys = m.keySet();
        for (String k : keys) {
            System.out.println("Chiave: " + k);
        }

        Collection<String> values = m.values();
        for (String v : values) {
            System.out.println("Valore: " + v);
        }

        for (String k : keys) {
            System.out.println(k + " -> " +m.get(k));
        }

        // Metodi di SortedMap
        System.out.println("First key: " + m.firstKey());
        System.out.println("Last key: " + m.lastKey());
        System.out.println(m.firstEntry());
        System.out.println(m.lastEntry());


    }
}