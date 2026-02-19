package Esercizio;

import java.time.LocalDate;

public class Attivita {

    private static int count = 1;
    private int id;
    private String utente;
    private TipoAttivita tipoAttivita;
    private double distanzaKm;
    private int calorie;
    private int durataMinuti;
    private LocalDate data;

    public Attivita(String utente, TipoAttivita tipoAttivita, double distanzaKm, int calorie, int durataMinuti, LocalDate data) {
        this.id = count++;
        this.utente = utente;
        this.tipoAttivita = tipoAttivita;
        this.distanzaKm = distanzaKm;
        this.calorie = calorie;
        this.durataMinuti = durataMinuti;
        this.data = data;
    }

    public int getId() {
        return id;
    }
    public String getUtente() {
        return utente;
    }
    public TipoAttivita getTipoAttivita() {
        return tipoAttivita;
    }
    public double getDistanzaKm() {
        return distanzaKm;
    }
    public int getCalorie() {
        return calorie;
    }
    public int getDurataMinuti() {
        return durataMinuti;
    }
    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Attivita{" +
                "id=" + id +
                ", utente='" + utente + '\'' +
                ", tipoAttivita=" + tipoAttivita +
                ", distanzaKm=" + distanzaKm +
                ", calorie=" + calorie +
                ", durataMinuti=" + durataMinuti +
                ", data=" + data +
                '}';
    }
}
