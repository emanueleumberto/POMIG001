public class Veicolo {

    private String marca;
    private String modello;
    private String colore;

    public Veicolo(String marca, String modello, String colore) {
        this.marca = marca;
        this.modello = modello;
        this.colore = colore;
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


}
