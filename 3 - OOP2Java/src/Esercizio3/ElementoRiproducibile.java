package Esercizio3;

public abstract class ElementoRiproducibile extends ElementoMultimediale {

    private int durata;

    public ElementoRiproducibile(String titolo, int durata) {
        super(titolo);
        this.durata = durata;
    }

    public int getDurata() { return durata; }

    public abstract void play();

}
