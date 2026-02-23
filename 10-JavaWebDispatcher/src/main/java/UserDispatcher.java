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

@WebServlet("/users")
public class UserDispatcher extends HttpServlet {


    private Logger logger = LoggerFactory.getLogger(UserDispatcher.class);

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.getWriter().append("Users page!");
        req.getRequestDispatcher("register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/registeredUser").include(req, resp);
        req.getRequestDispatcher("/savefile").include(req, resp);
        // User u = (User) req.getAttribute("user");
        // resp.getWriter().append(u.getNome() + " " + u.getCognome() + " salvato con successo!");

        req.getRequestDispatcher("/").forward(req, resp);
    }
}
