package Esercizio.service;

import Esercizio.exception.DatiIncopletiException;
import Esercizio.model.Cliente;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class ClienteGenerator {

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static Logger log = LoggerFactory.getLogger(ClienteGenerator.class);

    public static Cliente[] generaClienti(int numero) throws DatiIncopletiException {
        Cliente[] arrClienti = new Cliente[numero];
        for (int i = 0; i < numero; i++) {
            String nome = fake.name().firstName();
            String cognome = fake.name().lastName();
            String email = nome.toLowerCase().charAt(0)+"."+cognome.toLowerCase()+"@"+fake.internet().domainWord() + "." + fake.internet().domainSuffix();
            String telefono = fake.phoneNumber().cellPhone();
            String citta = fake.address().cityName();

            if(nome.length()<3 || cognome.length()<3 || !email.contains("@") || telefono.isBlank()) {
                throw new DatiIncopletiException("Dati non corretti!!!");
            }

            arrClienti[i] = new Cliente(nome, cognome,email,telefono,citta);
            log.debug("Cliente {} {} creato", nome, cognome);
        }
        log.info("Generati {} clienti fake.", numero);
        return arrClienti;
    }
}
