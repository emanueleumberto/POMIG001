public class Camper extends Veicolo {

    private int numLetti;

    public Camper(String marca, String modello, String colore, int numLetti) {
        super(marca, modello, colore);
        this.numLetti = numLetti;
    }

    public int getNumLetti() {
        return numLetti;
    }
    public void setNumLetti(int numLetti) {
        this.numLetti = numLetti;
    }

    public String info() {
        return "Camper: " + this.getMarca() + " " + this.getModello() + " colore: " + this.getColore() + " num.letti: " + this.numLetti;
    }
}
