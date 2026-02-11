public class Smartphone {

    private String marca;
    private String modello;
    private String colore;
    private int memoria;

    public Smartphone(String marca, String modello, String colore, int memoria) {
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
        this.memoria = memoria;
    }

    public String getMarca() {
        return marca;
    }
    public String getModello() {
        return modello;
    }
    public String getColore() {
        return colore;
    }
    public void setColore(String colore) {
        this.colore = colore;
    }
    public int getMemoria() {
        return memoria;
    }
    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public String info() {
        return "Smartphone: " +  this.marca + " " + this.modello + " colore: " + this.colore + " memoria: " + this.memoria;
    }
}
