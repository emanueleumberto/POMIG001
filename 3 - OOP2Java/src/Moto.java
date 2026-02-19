public class Moto extends Veicolo {

    private int numPosti;

    public Moto(String marca, String modello, String colore, int numPosti) {
        super(marca, modello, colore);
        this.numPosti = numPosti;
    }
    public int getNumPosti() {
        return numPosti;
    }
    public void setNumPosti(int numPosti) {
        this.numPosti = numPosti;
    }

    @Override
    public String info() {
        return "Moto: " + this.getMarca() + " " + this.getModello() + " colore: " + this.getColore() + " num.posti: " + this.numPosti;
    }

    @Override
    public void start() {
        System.out.println("Start Moto!");
    }

}
