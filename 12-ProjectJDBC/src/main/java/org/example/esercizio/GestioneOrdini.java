package org.example.esercizio;

import com.github.javafaker.Faker;
import org.example.esercizio.dao.ClienteDAO;
import org.example.esercizio.dao.OrdineDAO;
import org.example.esercizio.dao.ProdottoDAO;
import org.example.esercizio.entities.Cliente;
import org.example.esercizio.entities.DettaglioOrdine;
import org.example.esercizio.entities.Ordine;
import org.example.esercizio.entities.Prodotto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GestioneOrdini {

    private static Faker faker = new Faker(new Locale( "it-IT" ));

    public static void main( String[] args ) {
        try {
            DbConnection.getInstance();

            if(ClienteDAO.leggiTuttiClienti().size() == 0){
                generaClienti(10);
            }

            if(ProdottoDAO.leggiTuttiProdotti().size() == 0){
                generaProdotti(10);
            }

            if(OrdineDAO.leggiTuttiOrdini().size() == 0){
                generaOrdini(5);
            }

            // CRUD Cliente
            // ClienteDAO.leggiTuttiClienti().forEach(System.out::println);
            // Cliente c = ClienteDAO.leggiCliente(3);
            // ClienteDAO.modificaCliente(c);
            // ClienteDAO.eliminaCliente(ClienteDAO.leggiCliente(5));

            // CRUD Prodotto
            // ProdottoDAO.leggiTuttiProdotti().forEach(System.out::println);
            // Prodotto p = ProdottoDAO.leggiProdotto(4);
            // ProdottoDAO.modificaProdotto(p);
            // ProdottoDAO.eliminaProdotto(ProdottoDAO.leggiProdotto(7));

            // CRUD Ordine
            // List<DettaglioOrdine> carrello = new ArrayList<>();
            // carrello.add(new DettaglioOrdine(ProdottoDAO.leggiProdotto(4), 1));
            // carrello.add(new DettaglioOrdine(ProdottoDAO.leggiProdotto(7), 2));
            // carrello.add(new DettaglioOrdine(ProdottoDAO.leggiProdotto(1), 1));

            // Ordine o = new Ordine(ClienteDAO.leggiCliente(3), carrello);
            // OrdineDAO.creaOrdine(o);

            // Ordine o = OrdineDAO.leggiOrdine(1);
            // System.out.println(o);
            // o.getDettaglioOrdine().forEach(d -> {
            //    System.out.println("   - " + d);
            // });

            // o.getDettaglioOrdine().get(0).setQuantita(3);
            // o.setData_ordine(LocalDate.of(2026,02,03));
            // OrdineDAO.modificaOrdine(o);

            // OrdineDAO.eliminaOrdine(o);



        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void generaClienti(int num) throws SQLException {
        for (int i = 0; i < num; i++) {
            String nome = faker.name().firstName();
            String cognome = faker.name().lastName();
            String email = nome.toLowerCase().charAt(0) + cognome.toLowerCase() + "@example.com";
            String telefono = faker.phoneNumber().cellPhone();
            ClienteDAO.salvaCliente(new Cliente(nome, cognome, email, telefono));
        }
    }

    public static void generaProdotti(int num) throws SQLException {
        for (int i = 0; i < num; i++) {
            String nome = faker.commerce().productName();
            String descrizione = faker.lorem().paragraph();
            double prezzo = faker.number().randomDouble(2, 10, 1000);
            int quantita = faker.number().numberBetween(0,5);
            ProdottoDAO.salvaProdotto(new Prodotto(nome, descrizione, prezzo, quantita));
        }
    }

    public static void generaOrdini(int num) throws SQLException {
        for (int i = 0; i < num; i++) {
            List<DettaglioOrdine> carrello = new ArrayList<>();
            Random random = new Random();
            int numProdotti = random.nextInt(5)+1;
            for (int j = 0; j < numProdotti; j++) {
                carrello.add(
                        new DettaglioOrdine(
                                ProdottoDAO.leggiProdotto(random.nextInt(10)+1),
                                random.nextInt(5)
                        )
                );
            }
            Ordine o = new Ordine(ClienteDAO.leggiCliente(random.nextInt(10)+1), carrello);
            OrdineDAO.creaOrdine(o);
        }
    }
}
