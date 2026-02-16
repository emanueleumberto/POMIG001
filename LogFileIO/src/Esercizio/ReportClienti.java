package Esercizio;

import Esercizio.exception.DatiIncopletiException;
import Esercizio.model.Cliente;
import Esercizio.service.ClienteFileManager;
import Esercizio.service.ClienteGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReportClienti {

    private static File file = new File("csv/clienti.csv");
    private static Logger log = LoggerFactory.getLogger(ReportClienti.class);
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        log.info("Avvio applicazione...");

        try {
            if(file.exists() && ClienteFileManager.numClientiRegistrati()>0) {
                Cliente[] findClienti = ClienteFileManager.leggiClienti(ClienteFileManager.numClientiRegistrati());
                for (Cliente cliente : findClienti) {
                        System.out.println(cliente);
                }
            } else {
                System.out.print("Quanti clienti vuoi registrare?");
                int numClienti = Integer.parseInt(sc.nextLine());
                Cliente[] clienti = ClienteGenerator.generaClienti(numClienti);
                ClienteFileManager.salvaClienti(clienti);
            }

        } catch (IOException e) {
            log.error("IOException: {}", e.getMessage());
        }
         catch (DatiIncopletiException e) {
            log.error("DatiIncopletiException {}", e.getMessage());
        } catch (NumberFormatException e) {
            log.error("NumberFormatExcetption {}", e.getMessage());
        }

        log.info("Fine applicazione!");
    }

}
