package classes;

import exception.PagamentoException;

public class PagamentoCarta extends Pagamento{

    private String numeroCarta;
    private String intestatario;
    private String scadenza;

    public PagamentoCarta(String idTransazione, double importo, String numeroCarta, String intestatario, String scadenza) {
        super(idTransazione, importo);

        if(numeroCarta == null || numeroCarta.length() < 8) {
            throw new IllegalArgumentException("Numero di carta non valido!");
        }

        this.numeroCarta = numeroCarta;
        this.intestatario = intestatario;
        this.scadenza = scadenza;
    }

    @Override
    public void eseguiPagamento() throws PagamentoException {
        //Il pagamento viene eseguito due volte
        if(completato) {
            throw new PagamentoException("Pagamento già completato");
        }
        System.out.println("Pagamento con carta in elaborazione....");
        completato = true;
    }
}
