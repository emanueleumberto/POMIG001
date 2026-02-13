package classes;

import exception.PagamentoException;

public class PagamentoPayPal extends Pagamento{

    private String email;
    private String password;

    public PagamentoPayPal(String idTransazione, double importo, String email, String password) {
        super(idTransazione, importo);

        if(email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email non valida!");
        }

        if(password == null || password.length() < 3) {
            throw new IllegalArgumentException("Password non valida!");
        }

        this.email = email;
        this.password = password;
    }

    @Override
    public void eseguiPagamento() throws PagamentoException {
        //Il pagamento viene eseguito due volte
        if(completato) {
            throw new PagamentoException("Pagamento già completato");
        }
        System.out.println("Pagamento con PayPal in elaborazione....");
        completato = true;
    }
}
