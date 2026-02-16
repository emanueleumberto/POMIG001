import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class Main {

    // Java Faker è una libreria che mi permette di generare dati fake
    private static Faker faker = new Faker(new Locale("it-IT"));

    // Logger è una libreria che mi permette di gestire log avanzati su terminale e/o su file
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    // Creo un file per la lettura/scrittura di dati
    private static File file = new File("file/backup.txt");

    public static void main(String[] args) {

        // Gestione dei livelli di LOG
        logger.debug("Sono il log DEBUG");
        logger.info("Sono il log INFO");
        logger.warn("Sono il log Warning");
        logger.error("Sono il log ERROR");

        // test dati fake con JavaFaker
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        System.out.println("Ciao " + firstName + " " + lastName);

//        try {
//            scriviSuFile("Test di scrittura!");
//            scriviSuFile("Altro testo.");
//            String str = leggiDaFile();
//            System.out.println(str);
//            cancellaFile();
//            cancellaDirectory();
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//        }


        try {
            // salvaUtenteSuFile(creaUtente());
            // generaUtenti(15);
            Utente[] listaUtenti = leggiUtentiDaFile();

            listaUtenti[3].setActive(true);
            listaUtenti[7].setActive(true);
            listaUtenti[12].setActive(true);

            for (int i = 0; i < listaUtenti.length; i++) {
                System.out.println(listaUtenti[i]);
            }

            aggiornaUtentiSuFile(listaUtenti);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }

    public static void scriviSuFile(String str) throws IOException {
        FileUtils.writeStringToFile(file, str, "UTF-8", true);
        logger.info(str + " salvato su file!");
    }

    public static String leggiDaFile() throws IOException {
        return FileUtils.readFileToString(file, "UTF-8");
    }

    public static void cancellaFile() throws IOException {
        FileUtils.deleteQuietly(file);
        logger.info("File " + file.getName() + " eliminato!");
    }

    public static void cancellaDirectory() throws IOException {
        FileUtils.deleteDirectory(new File("file/"));
        logger.info("Directory file eliminata!");
    }

    public static Utente creaUtente() {
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        int age = faker.number().numberBetween(18, 67);
        String city = faker.address().cityName();
        String email = firstname.toLowerCase().charAt(0) + "." + lastname.toLowerCase() + "@" + faker.internet().domainWord() + "." + faker.internet().domainSuffix();
        String password = faker.internet().password(true);
        return new Utente(firstname,lastname,age,city,email,password);
    }

    public static void salvaUtenteSuFile(Utente u) throws IOException {
        String txt = u.getId()+","+u.getFirstname()+","+u.getLastname()+","+
                     u.getAge()+","+u.getCity()+","+u.getEmail()+","+
                     u.getPassword()+","+u.isActive();
        txt += System.lineSeparator();
        FileUtils.writeStringToFile(file, txt, "UTF-8", true);
        logger.info(u.getFirstname() + " " + u.getLastname() + " salvato su file!");
    }

    public static void generaUtenti(int num) throws IOException {
        for (int i = 0; i < num; i++) {
            salvaUtenteSuFile(creaUtente());
        }
    }

    public static Utente[] leggiUtentiDaFile() throws IOException {
        Utente[] arrUtenti = new Utente[15];
        String txt = FileUtils.readFileToString(file, "UTF-8");
        String[] utenti = txt.split(System.lineSeparator());
        for (int i = 0; i < utenti.length; i++) {
            String[] u = utenti[i].split(",");
            int id = Integer.parseInt(u[0]);
            String firstname = u[1];
            String lastname = u[2];
            int age = Integer.parseInt(u[3]);
            String city = u[4];
            String email = u[5];
            String password = u[6];
            boolean active = Boolean.parseBoolean(u[7]);
            Utente utente = new Utente(id,firstname, lastname,age,city,email,password,active);
            arrUtenti[i] = utente;
        }
        return arrUtenti;
    }

    public static void aggiornaUtentiSuFile(Utente[] utenti) throws IOException {
        cancellaFile();
        for (int i = 0; i < utenti.length; i++) {
            salvaUtenteSuFile(utenti[i]);
        }
    }
}