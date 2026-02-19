package Esercizio.service;

import Esercizio.model.Cliente;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ClienteFileManager {

    private static Logger log = LoggerFactory.getLogger(ClienteFileManager.class);
    private static File file = new File("csv/clienti.csv");

    public static void salvaClienti(Cliente[] clienti) throws IOException {
        String txt = "";
        for (int i = 0; i < clienti.length; i++) {
            txt += clienti[i].toFileString();
        }
        FileUtils.writeStringToFile(file, txt, "UTF-8", false);
    }

    public static Cliente[] leggiClienti(int numero) throws IOException {
        Cliente[] clienti = new Cliente[numero];

        // Soluzione 1
         String str = FileUtils.readFileToString(file, "UTF-8");
         String[] arrStr = str.split(System.lineSeparator());

        // Soluzione 2
        // String[] arrStr = FileUtils.readLines(file, "UTF-8").toArray(String[]::new);

        for (int i = 0; i < numero; i++) {
            String row = arrStr[i];
            String[] u = row.split(",");

            int id = Integer.parseInt(u[0]);
            String nome = u[1];
            String cognome = u[2];
            String email = u[4];
            String telefono = u[5];
            String citta = u[3];

            clienti[i] = new Cliente(id, nome, cognome,email,telefono,citta);
        }

        return clienti;
    }

    public static int numClientiRegistrati() throws IOException {
        return FileUtils.readLines(file, "UTF-8").size();
    }
}
