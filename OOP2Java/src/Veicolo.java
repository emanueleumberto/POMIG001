public abstract class Veicolo {

    private String marca;
    private String modello; // Modificatore di accesso Package o Default
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

    public abstract String info();

    public abstract void start();

    // Overloading dei metodi -> Creare metodi con lo stesso nome ma con firma diversa
    // Numero di paramentri | Tipo di parametri | Posizione dei paramentri

    public void testPolimorfismo() {
        System.out.println("Sono il metodo testPolimorfismo");
    }

    public void testPolimorfismo(String param) {
        System.out.println("Sono il metodo testPolimorfismo con param");
    }

    public void testPolimorfismo(int param) {
        System.out.println("Sono il metodo testPolimorfismo con param");
    }

    public void testPolimorfismo(String param1, int param2) {
        System.out.println("Sono il metodo testPolimorfismo con param1 e param2");
    }

    public void testPolimorfismo(int param2, String param1) {
        System.out.println("Sono il metodo testPolimorfismo con param1 e param2");
    }


}
