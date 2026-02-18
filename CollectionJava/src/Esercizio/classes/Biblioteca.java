package Esercizio.classes;

import Esercizio.exceptions.LettoreException;
import Esercizio.exceptions.LibroException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Biblioteca {

    private String nome;
    private List<Libro> libriDisponibili;
    private Set<Lettore> utentiRegistrati;
    private Map<Lettore, Set<Libro>> prestiti;

    private Logger log = LoggerFactory.getLogger(Biblioteca.class);
    private File file = new File("report/prestiti.csv");

    public Biblioteca(String nome) {
        this.nome = nome;
        this.libriDisponibili = new ArrayList<>();
        this.utentiRegistrati = new HashSet<>();
        this.prestiti = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }
    public List<Libro> getLibriDisponibili() {
        return libriDisponibili;
    }
    public Set<Lettore> getUtentiRegistrati() {
        return utentiRegistrati;
    }
    public Map<Lettore, Set<Libro>> getPrestiti() {
        return prestiti;
    }

    public void aggiungiLibro(Libro libro) {
        this.libriDisponibili.add(libro);
        log.debug("Libro {} aggiunto alla biblioteca!", libro.getTitolo() );
    }

    public void registraLettore(Lettore lettore) throws LettoreException {
        if(!this.utentiRegistrati.add(lettore)) {
            //System.out.println("Utente duplicato!!!");
            throw new LettoreException("Utente duplicato!!!");
        } else {
            log.debug("Lettore {} registrato nela biblioteca!", lettore.getNome());
        }
    }

    public boolean prestaLibro(Lettore lettore, String isbn) throws LibroException, LettoreException, IOException {
        Libro libro = trovaLibroDaISBN(isbn); // Cerco ul libro disponibile dato un ISBN -> obj || null
        // Se il libro(null) non è presente nella biblioteca
        if(libro == null) { throw new LibroException("Codice ISBN non trovato!"); }
        // Controllo se il lettore è contenuto nella lista dei lettori registrati
        if(this.utentiRegistrati.contains(lettore)) {
            // Lettore OK e Libro OK
            // Creo una collection di tipo set prestiti
            Set<Libro> listaPrestitiLettore;
            if(this.prestiti.containsKey(lettore))
                // Se nella mappa di prestiti esiste già una chiave per il lettore selezionato
                // leggo la lista di prestiti già associata a quel lettore
                listaPrestitiLettore = this.prestiti.get(lettore);
            else {
                // Altrimenti ne creo una nuova
                listaPrestitiLettore = new HashSet<>();
            }
            listaPrestitiLettore.add(libro); // aggiungo il libro ai prestiti
            this.prestiti.put(lettore, listaPrestitiLettore); // Salvo la lista di prestiti nella mappa
            this.libriDisponibili.remove(libro); // rimuovo il libro preso in prestito dalla lista dei libri disponibili
            log.info("Libro {} preso in prestito da {}.", libro.getTitolo(), lettore.getNome());
            // scrittura su file di testo del prestito effettuato
            String report = LocalDate.now() + ", " + lettore.getNome() + ", " + libro.getTitolo() + System.lineSeparator();  //(17/02/2026, Mario Rossi, Harry Potter)
            FileUtils.writeStringToFile(file, report, "UTF-8", true);
            log.info(report + " salvato su file!");
            return true;
        } else {
            throw new LettoreException("Lettore non registrato nella Biblioteca!");
        }
    }

    public Libro trovaLibroDaISBN(String isbn) {
        for (Libro l : this.libriDisponibili) {
            if(l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    public Lettore trovaLettoreDaId(int id) {
        for (Lettore l : this.utentiRegistrati) {
            if(l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public Set<Libro> getLibriInPrestito(Lettore lettore) throws LettoreException {
        if(this.prestiti.containsKey(lettore)) {
            return this.prestiti.get(lettore);
        } else {
            throw new LettoreException("Nessun prestito associato al lettore " + lettore.getNome());
        }
    }

    public boolean restituisciLibro(Lettore lettore, String isbn) throws LibroException, LettoreException {

        // Controllo se il lettore è contenuto nella lista dei lettori registrati
        if(this.utentiRegistrati.contains(lettore)) {
            // Lettore OK e Libro OK
            Set<Libro> prestitoUtente = this.getLibriInPrestito(lettore); // Vado a leggere tutti i prestiti del lettore
            for (Libro l : prestitoUtente) {
                if(l.getIsbn().equals(isbn)) {
                    prestitoUtente.remove(l);
                    this.libriDisponibili.add(l);
                    log.info(" Libro {} restituito da {}." , l.getTitolo(), lettore.getNome());
                    return true;
                }
            }
            throw new LibroException("Il libro che vuoi restituire non è presente tra i tuoi prestiti!");
        } else {
            throw new LettoreException("Lettore non registrato nella Biblioteca!");
        }
    }

    public void stampaPrestiti() {
        for (Lettore lettore : this.prestiti.keySet()) {
            log.info("Prestiti di {}", lettore.getNome());
            for (Libro libro : this.prestiti.get(lettore)) {
                log.info("   - {}", libro.getTitolo());
            }
            log.info("------------------------");
        }
    }


}
