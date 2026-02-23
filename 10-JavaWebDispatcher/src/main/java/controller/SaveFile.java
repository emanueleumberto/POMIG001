package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/savefile")
public class SaveFile extends HttpServlet {

    private String filePath;
    private Logger logger = LoggerFactory.getLogger(SaveFile.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        filePath = config.getServletContext().getRealPath("/WEB-INF/partecipanti.txt");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File(filePath);
        User u = (User) req.getAttribute("user");
        FileUtils.writeStringToFile(file,u + System.lineSeparator(), StandardCharsets.UTF_8, true);
        logger.debug("Utente salvato con successo");
    }
}
