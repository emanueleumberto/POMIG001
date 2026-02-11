public class Automobile {

    // Membri della classe
    // Attributi o proprietà di istanza
    public String marca;
    public String modello;
    public int cilindrata;
    public String colore;
    public String targa;
    public boolean motoreAcceso;
    public TipoAlimentazione alimentazione;
    public static int count = 0; // Attributo o proprietà di classe

    // Metodo costruttore
    public Automobile(String marca, String modello, int cilindrata, String colore, TipoAlimentazione alimentazione) {
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.colore = colore;
        this.alimentazione = alimentazione;
        this.motoreAcceso = false;
        count++;
    }

    public Automobile(String marca, String modello, int cilindrata, String colore, TipoAlimentazione alimentazione, String targa) {
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.colore = colore;
        this.alimentazione = alimentazione;
        this.targa = targa;
        this.motoreAcceso = false;
        count++;
    }

    // Metodi di istanza
    public void start() {
        this.motoreAcceso = true;
        System.out.println("Automobile " + this.marca + " " + this.modello + " start!");
    }

    public void stop() {
        this.motoreAcceso = false;
        System.out.println("Automobile " + this.marca + " " + this.modello + " stop!");
    }

    public void info() {
        System.out.println("***** Automobile " + this.marca + " " + this.modello + " *****");
        System.out.println("Cilindrata: " + this.cilindrata);
        System.out.println("Colore: " + this.colore);
        System.out.println("Alimentazione: " + this.alimentazione);
        System.out.println("Targa: " + this.targa);
        if(this.motoreAcceso) {
            System.out.println("Motore Acceso");
        } else {
            System.out.println("Motore Spento");
        }
        System.out.println("***** ---- ******");
    }

    // Metodi di classe
    public static void conteggioAutoProdotte() {
        System.out.println("Numero di auto prodotte: " + count);
    }
}

