import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/path-richiesto-dal-client")
public class MiaServlet extends HttpServlet {
    // Creare una Servlet vuol dire creare una classe Java che estende la classe Astratta HttpServlet
    // Classe HttpServlet che ha tutti i metodi per gestire il ciclo di vita di una servlet
    // in più ha tutti i metodi per poter comunicare con il protocollo HTTP per applicazioni MVC (GET-POST)
    // e tutti i metodi per applicazione di tipo RESTFULL (GET-POST-PUT-PATCH-DELETE)

    // Una Servlet ha un ciclo di vita ben definito che indica come:
    //  -> Caricare una Servlet
    //  -> Istanziare un oggetto dalla Servlet
    //  -> Inizializzare una Servlet
    //  -> Gestiore le richieste da parte del client
    //  -> Eliminare una servlet

    public MiaServlet() {
        System.out.println("Sono il metodo costruttore!");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Sono il metodo init!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Sono il metodo doGet");
        System.out.println("Method: " + req.getMethod());
        System.out.println("Locale: " + req.getLocale());
        System.out.println("HeaderNames: " + req.getHeaderNames());
        System.out.println("ContextPath: " + req.getContextPath());

        // resp.getWriter().append("Ciao");
        resp.getWriter().println("<h1> Ciao a tutti </h1>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Sono il metodo doPost");
        //super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Sono il metodo destroy!");
    }
}