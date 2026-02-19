package Esercizio;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalisiFitnessTask implements Runnable{

    private List<Attivita> lista;
    private int analisi;

    public AnalisiFitnessTask(List<Attivita> lista, int analisi) {
        this.lista = lista;
        this.analisi = analisi;
    }

    @Override
    public void run() {
        switch (analisi) {
            case 1:
                // 1 - Calcola distanza totale
                System.out.println("1 - Calcola distanza totale");

                try {
                    double kmTotali = lista.stream()
                            .map(Attivita::getDistanzaKm)
                            .reduce(0.0, Double::sum);
                    Thread.sleep(1000);
                    System.out.println("Distanza totale in km: " + kmTotali);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

                break;
            case 2:
                // 2 - Trova attività più lunga
                System.out.println("2 - Trova attività più lunga");
                try {
                    Thread.sleep(1500);
                    lista.stream()
                            .max(Comparator.comparingInt(Attivita::getDurataMinuti))
                            .ifPresent(System.out::println);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

                break;
            case 3:
                // 3 - Statistiche calorie per utente
                System.out.println("3 - Statistiche calorie per utente");
                try {
                    Thread.sleep(500);
                    Map<String, Integer> caloriePerUtente = lista.stream()
                            .collect(Collectors.groupingBy(
                                    Attivita::getUtente,
                                    Collectors.summingInt(Attivita::getCalorie)));
                    caloriePerUtente.forEach((k,v)-> System.out.println(k + " -> " + v));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

                break;
        }
    }
}
