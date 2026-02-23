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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getfile")
public class GetFile extends HttpServlet {

    private String filePath;
    private Logger logger = LoggerFactory.getLogger(GetFile.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        filePath = config.getServletContext().getRealPath("/WEB-INF/partecipanti.txt");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> lista = new ArrayList<>();
        File file = new File(filePath);
        FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        String txt =FileUtils.readFileToString(file,StandardCharsets.UTF_8);
        String[] row = txt.split(System.lineSeparator());
        for (int i = 0; i < row.length; i++) {
            // id + "," + nome + "," + cognome + "," + email + "," + username + "," + password
            String[] properties = row[i].split(",");
            int id = Integer.parseInt(properties[0]);
            String nome = properties[1];
            String cognome = properties[2];
            String email = properties[3];
            String username = properties[4];
            String password = properties[5];
            lista.add(new User(id, nome, cognome, email, username, password));
        }
        req.setAttribute("userlist",  lista);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
