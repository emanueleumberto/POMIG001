package Esercizio3;

public class Video extends ElementoRiproducibile implements GestioneVolume, GestioneLuminosita{

    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata);
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public int getVolume() { return volume; }
    public int getLuminosita() { return luminosita; }


    @Override
    public void play() {
        // Soluzione 1
//        for (int i = 0; i < this.getDurata(); i++) {
//            System.out.print(this.getTitolo());
//            for (int j = 0; j < this.volume; j++) {
//                System.out.print("!");
//            }
//            for (int k = 0; k < this.luminosita; k++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        // Soluzione 2
        for (int i = 0; i < this.getDurata(); i++) {
            System.out.println(this.getTitolo()
                                    + "!".repeat(this.volume)
                                    + "*".repeat(this.luminosita));
        }
    }

    @Override
    public void alzaVolume() {
        if(this.volume < 6) {
            this.volume++;
        } else if(this.volume < 10) {
            this.volume++;
            System.out.println("Attenzione! Non tenere il volume troppo alto");
        } else {
            System.out.println("Volume massimo raggiunto!");
        }
    }

    @Override
    public void abbassaVolume() {
        if(this.volume > 0) {
            this.volume--;
        } else {
            System.out.println("Volume minimo raggiunto!");
        }
    }

    @Override
    public void aumentaLuminosita() {
        if(this.luminosita < 10) {
            this.luminosita++;
        } else {
            System.out.println("Luminosità massima raggiunta!");
        }
    }

    @Override
    public void diminuisciLuminosita() {
        if(this.luminosita > 0) {
            this.luminosita--;
        } else {
            System.out.println("Luminosità minima raggiunta!");
        }
    }
}
