package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Partecipante;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/registrazione")
public class RegistrazioneServlet extends HttpServlet {

    private String filePath;
    private Logger logger = LoggerFactory.getLogger(RegistrazioneServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        filePath = config.getServletContext().getRealPath("/WEB-INF/partecipanti.txt");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("firstname");
        String cognome = req.getParameter("lastname");
        String email = req.getParameter("email");
        String tiket = req.getParameter("tiket");

       // Validazione campi
        if(nome.isEmpty() || cognome.isEmpty() || tiket.isEmpty() || !email.contains("@")) {
            System.out.println("Dati non validi");
            req.setAttribute("errore", "Dati non validi");
            req.getRequestDispatcher("form.jsp").forward(req, resp);
            return;
        }

        Partecipante p = new Partecipante(nome, cognome, email, tiket);
        salvaPartecipante(p);
        List<Partecipante> listaPartecipante = leggiPartecipanti();
        req.setAttribute("listaPartecipante", listaPartecipante);
        req.getRequestDispatcher("lista.jsp").forward(req, resp);
    }

    private void salvaPartecipante(Partecipante p) throws IOException {
        File file = new File(filePath);
        FileUtils.writeStringToFile(file,p + System.lineSeparator(), StandardCharsets.UTF_8, true);
        logger.debug("Partecipante salvato con successo");
    }

    private List<Partecipante> leggiPartecipanti() throws IOException {
        List<Partecipante> listaPartecipanti = new ArrayList<>();
        File file = new File(filePath);
        String txt =FileUtils.readFileToString(file,StandardCharsets.UTF_8);
        String[] row = txt.split(System.lineSeparator());
        for (int i = 0; i < row.length; i++) {
            String[] properties = row[i].split(",");
            int id = Integer.parseInt(properties[0]);
            String nome = properties[1];
            String cognome = properties[2];
            String email = properties[3];
            String tiket = properties[4];
            Partecipante p = new Partecipante(id, nome, cognome, email, tiket);
            listaPartecipanti.add(p);
        }
        return listaPartecipanti;
    }
}
