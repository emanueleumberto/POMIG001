package Esercizio3;

public class Audio extends ElementoRiproducibile implements GestioneVolume {

    private int volume;

    public Audio(String titolo, int durata, int volume) {
        super(titolo, durata);
        this.volume = volume;
    }

    public int getVolume() { return volume; }

    @Override
    public void play() {
        // Titolo -> MiaCanzone
        // Durata -> 3
        // Volume -> 5
        // play() -> MiaCanzone!!!!!
        //           MiaCanzone!!!!!
        //           MiaCanzone!!!!!

        // Soluzione 1
//        for (int i = 0; i < this.getDurata(); i++) {
//            System.out.print(this.getTitolo());
//            for (int j = 0; j < this.volume; j++) {
//                System.out.print("!");
//            }
//            System.out.println();
//        }

        // Soluzione 2
        for (int i = 0; i < this.getDurata(); i++) {
            System.out.println(this.getTitolo() + "!".repeat(this.volume));
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
}
