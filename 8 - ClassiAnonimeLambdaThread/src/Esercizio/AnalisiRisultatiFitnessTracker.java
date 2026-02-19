package Esercizio;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AnalisiRisultatiFitnessTracker {

    private static List<Attivita> listaAttivita = new ArrayList<>();
    private static Faker fake = new Faker(new Locale("it-IT"));

    public static void main(String[] args) {
        creaAttivita(25);

        // listaAttivita.forEach(System.out::println);

        // Stampare attività con: calorie > 400
        listaAttivita.stream()
                .filter(a -> a.getCalorie() > 400)
                .forEach(System.out::println);
        System.out.println("***********************************");
        // Creare lista utenti senza duplicati.
        List<String> utenti = listaAttivita.stream()
                .map(Attivita::getUtente)
                .distinct()
                .toList();
        utenti.forEach(System.out::println);
        System.out.println("***********************************");
        // Stampare attività ordinate per: durata decrescente
        listaAttivita.stream()
                .sorted(Comparator
                        .comparingInt(Attivita::getDurataMinuti)
                        .reversed())
                .forEach(System.out::println);
        // Calcolare i km totali percorsi da tutti gli utenti
        System.out.println("***********************************");
        double distanzaPercorsa = listaAttivita.stream()
                .map(Attivita::getDistanzaKm)
                .reduce(0.0, Double::sum);
        System.out.println("km totali percorsi da tutti gli utenti: " + distanzaPercorsa);
        // Raggruppamento per tipo attività
        System.out.println("***********************************");
        Map<TipoAttivita, Long> gruppi = listaAttivita.stream()
                .collect(Collectors.groupingBy(
                        Attivita::getTipoAttivita
                        ,Collectors.counting()
                        ));
        gruppi.forEach((k,v) -> System.out.println(k + " -> " + v + " attività"));
        // Calcolare: utente con più calorie bruciate complessive.
        System.out.println("***********************************");
//        Map<String, Integer> calorie = listaAttivita.stream()
//                .collect(Collectors.groupingBy(
//                        Attivita::getUtente,
//                        Collectors.summingInt(Attivita::getCalorie)
//                ));
//        calorie.forEach((k,v) -> System.out.println(k + " -> " + v));
        listaAttivita.stream()
                .collect(Collectors.groupingBy(
                        Attivita::getUtente,
                        Collectors.summingInt(Attivita::getCalorie)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
        System.out.println("***********************************");
        // thread attività
        // 1 - Calcola distanza totale.
        // 2 - Trova attività più lunga.
        // 3 - Statistiche calorie per utente.
        Thread t1 = new Thread(new AnalisiFitnessTask(listaAttivita,2));
        Thread t2 = new Thread(new AnalisiFitnessTask(listaAttivita,1));
        Thread t3 = new Thread(new AnalisiFitnessTask(listaAttivita,3));

        t1.start();
        t2.start();
        t3.start();

    }

    public static void creaAttivita(int num) {
        TipoAttivita[] tipo = {TipoAttivita.BICI, TipoAttivita.NUOTO, TipoAttivita.CORSA, TipoAttivita.CAMMINATA};
        List<String> utenti = List.of(fake.name().fullName(), fake.name().fullName(), fake.name().fullName(),fake.name().fullName(),fake.name().fullName());


        for (int i = 0; i < num; i++) {
            String utente = utenti.get(fake.number().numberBetween(0, utenti.size()));
            TipoAttivita tipoAttivita = tipo[fake.number().numberBetween(0, tipo.length)];
            double distanzaKm = fake.number().randomDouble(1,0, 15);
            int calorie = (int) (distanzaKm * 150);
            int durataMinuti = fake.number().numberBetween(30, 120);
            LocalDate data = LocalDate.now();

            listaAttivita.add(new Attivita(utente,tipoAttivita,distanzaKm,calorie,durataMinuti,data));
        }
    }
}
