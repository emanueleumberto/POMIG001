import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class IndexServletDispatcher extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Sono il metodo doGet");
        // .forward(req, resp) -> invio la req ad una risorsa e la risorsa si preoccupa di inviare una resp al client
        // .include(req, resp) -> invio la req ad una risorsa e la risorsa mi ritorna indietro la risposta
        req.getRequestDispatcher("/getfile").include(req, resp);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.getWriter().println("Sono il metodo doPost");
        doGet(req, resp);
    }
}
