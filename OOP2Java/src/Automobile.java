public class Automobile extends Veicolo {

    private int numPorte;

    public Automobile(String marca, String modello, String colore, int numPorte) {
        super(marca, modello, colore); // Richiamo il costruttore della superclasse Veicolo
        this.numPorte = numPorte;
    }

    public int getNumPorte() {
        return numPorte;
    }

    @Override
    public String info() {
        return "Automobile: " +  this.getMarca() + " " + this.getModello() + " colore: " + this.getColore() + " num.porte: " + this.numPorte;
    }

    @Override
    public void start() {
        System.out.println("Start Automobile!");
    }

}
