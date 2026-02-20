import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/saveuser")
public class userServlet extends HttpServlet {

    private List<User> userList;

    /**
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        userList = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Sono il metodo doGet</h1>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("<h1>Sono il metodo doPost</h1>");
        String nome = req.getParameter("firstname");
        String cognome = req.getParameter("lastname");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        userList.add(new User(nome,cognome,email,username,password));
        System.out.println("Utenti registrati: " + userList.size());

        //resp.getWriter().println("<h1>Registrazione effettuata da " + nome + " " + cognome + " il " + LocalDate.now());

        req.setAttribute("firstname", nome);
        req.setAttribute("lastname", cognome);
        req.setAttribute("email", email);

        req.setAttribute("lista", userList);

        req.getRequestDispatcher("users.jsp").forward(req,resp);



    }
}
