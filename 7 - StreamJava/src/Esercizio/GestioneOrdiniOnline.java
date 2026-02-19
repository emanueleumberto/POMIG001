package Esercizio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestioneOrdiniOnline {
    public static void main(String[] args) {
        List<Ordine> ordini = new ArrayList<>();

        // ----- Clienti ------
        Cliente c1 = new Cliente("Mario", "Rossi", "Roma", 45);
        Cliente c2 = new Cliente("Giuseppe", "Verdi", "Milano", 23);
        Cliente c3 = new Cliente("Francesca", "Neri", "Torino", 34);

        // ----- Prodotti ------
        Prodotto p1 = new Prodotto("Laptop", "Elettronica", 899.00);
        Prodotto p2 = new Prodotto("Libro Java", "Libri", 29.99);
        Prodotto p3 = new Prodotto("Lampada", "Casa", 89.00);
        Prodotto p4 = new Prodotto("Sacco Boxe", "Sport", 198.00);
        Prodotto p5 = new Prodotto("Sql Book", "Libri", 19.00);
        Prodotto p6 = new Prodotto("Sedia", "Casa", 32.00);
        Prodotto p7 = new Prodotto("Caffettiera", "Casa", 18.99);
        Prodotto p8 = new Prodotto("Alexa", "Elettronica", 36.00);
        Prodotto p9 = new Prodotto("Smartphone", "Elettronica", 749.00);
        Prodotto p10 = new Prodotto("Panca Addominali", "Sport", 99.00);

        // ----- Ordini ------
        ordini.add(new Ordine(c2, List.of(p3,p7,p1)));
        ordini.add(new Ordine(c1, List.of(p2,p5,p6)));
        ordini.add(new Ordine(c3, List.of(p3,p5,p1,p9,p10)));
        ordini.add(new Ordine(c2, List.of(p8,p7,p1,p6)));
        ordini.add(new Ordine(c1, List.of(p2,p1,p7,p9)));
        ordini.add(new Ordine(c3, List.of(p1,p2,p5,p6,p7)));
        ordini.add(new Ordine(c1, List.of(p8,p2)));

        // ---------------------------------
        // --- Ordini con: prezzo > 100€ ---
        // ---------------------------------
        System.out.println("Ordini con: prezzo > 100€");
        ordini.stream()
                .filter(o -> o.getTotaleOrdine() > 100)
                .forEach(System.out::println);

        // ------------------------------------
        // --- Nomi clienti senza duplicati ---
        // ------------------------------------
        System.out.println("Nomi clienti senza duplicati");
        List<String> nomiClienti = ordini.stream()
                .map(o -> o.getCliente().getNome() + " " + o.getCliente().getCognome())
                .distinct()
                .toList();
        nomiClienti.forEach(System.out::println);

        // -------------------------------------
        // --- Ordini per prezzo decrescente ---
        // -------------------------------------
        System.out.println("Ordini per prezzo decrescente");
        ordini.stream()
                .sorted(Comparator
                            .comparingDouble(Ordine::getTotaleOrdine)
                            .reversed())
                .forEach(System.out::println);

        // ----------------------------
        // --- Valore totale ordini ---
        // ----------------------------
        System.out.println("Valore totale ordini");
        double totale = ordini.stream()
                .mapToDouble(Ordine::getTotaleOrdine)
                .reduce(0.0, Double::sum);
        System.out.println("Totale vendite: " + totale);

        // ----------------------------
        // --- Ordini per categoria ---
        // ----------------------------
        System.out.println("Ordini per categoria (Forzato)");
        Map<String, List<Ordine>> ordiniPerCategria = ordini.stream().collect(Collectors.groupingBy(ordine -> ordine.getListaProdotti().get(0).getCategoria()));
        ordiniPerCategria.forEach((cat, val) -> {
            System.out.println(cat);
            val.forEach(p -> System.out.println(" - " + p));
        } );

        // ----------------------------
        // --- Cliente TOP spender ----
        // ----------------------------
        System.out.println("Cliente TOP spender");
//        Map<String, List<Ordine>> test = ordini.stream()
//                .collect(Collectors
//                        .groupingBy(o -> o.getCliente().getNome() + " " + o.getCliente().getCognome()));
//
//        test.forEach((k,v) -> {
//            System.out.println(k + ": ");
//            v.forEach(System.out::println);
//        });

        Map<String, Double> spesaCliente = ordini.stream()
                .collect(Collectors
                        .groupingBy(o -> o.getCliente().getNome() + " " + o.getCliente().getCognome(),
                                Collectors.summingDouble(Ordine::getTotaleOrdine)
                        ));
        spesaCliente.forEach((k,v) -> System.out.println(k + " -> " + v));

        spesaCliente.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);
    }
}
