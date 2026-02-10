public class Test {

    // Una classe è un raggruppamento concettuale
    // che definisce le caratteristiche condivise tra tutti gli oggetti

    // Membri della classe

    // Attributi o proprietà di istanza
    // Scope globale
    String nome;
    String tipo;

    // Metodo costruttore
    public Test(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    // Metodi di istanza
    public void info() {
        String locale = "Sono una variabile locale";
        System.out.println("Nome: " + this.nome + " Tipo: " + this.tipo);
    }

    public void abc() {
        // Scope di metodo
        String localeAbc = "Sono una variabile locale";
        if(true) {
            // Scope di Blocco
            String blocco = "Sono una variabile di blocco";
            System.out.println(nome);
            System.out.println(localeAbc);
            System.out.println(blocco);
            //System.out.println(locale); // Errore non posso leggere variabili definite in un altro metodo
        }
        System.out.println(nome);
        System.out.println(localeAbc);
        // System.out.println(blocco); // Errore non posso leggere variabili definite in un altro blocco
        // System.out.println(locale); // Errore non posso leggere variabili definite in un altro metodo
    }

}


