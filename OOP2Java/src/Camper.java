public class Camper extends Veicolo implements Navigatore{

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

    @Override
    public String info() {
        return "Camper: " + this.getMarca() + " " + this.getModello() + " colore: " + this.getColore() + " num.letti: " + this.numLetti;
    }

    @Override
    public void start() {
        System.out.println("Start Camper!");
    }

    @Override
    public void startNavigatore() {
        System.out.println("Start navigatore su Camper");
    }

    @Override
    public void stopNavigatore() {
        System.out.println("Stop navigatore su Camper");
    }

    @Override
    public void aggiornaNavigatore() {
        System.out.println("Aggiorna navigatore su Camper");
    }
}
