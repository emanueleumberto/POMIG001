import classes.Pagamento;
import classes.PagamentoCarta;
import classes.PagamentoPayPal;
import exception.PagamentoException;

public class Main {
    public static void main(String[] args) {

        Pagamento[] pagamenti = new Pagamento[5];

        try {
            PagamentoCarta pc1 = new PagamentoCarta("P001", 120.50, "123456789", "Mario Rossi", "12/27");
            PagamentoPayPal py1 = new PagamentoPayPal("P002", 75.00, "utente@example.com", "Pa$$w0rd!");
            PagamentoCarta pc2 = new PagamentoCarta("P003", 210.90, "987654321", "Giuseppe Verdi", "05/26");

            pagamenti[0] = pc1;
            pagamenti[1] = py1;
            pagamenti[2] = pc2;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("************");

        for (int i = 0; i < pagamenti.length; i++) {
            if(pagamenti[i] != null) {
                try {
                    pagamenti[i].eseguiPagamento();
                    pagamenti[i].stampaDettagli();
                } catch (PagamentoException e) {
                    System.err.println("Errore nel pagamento: " + e.getMessage());
                }
            }
        }

        // Tentativo di doppio pagamento
        try {
            pagamenti[1].eseguiPagamento();
        } catch (PagamentoException e) {
            System.err.println("Errore nel pagamento: " + e.getMessage());
        }

        System.out.println("Stampa pagamenti copletati");
        for (Pagamento p : pagamenti) {
            if(p != null && p.isCompletato()) {
                p.stampaDettagli();
            }
        }

    }
}