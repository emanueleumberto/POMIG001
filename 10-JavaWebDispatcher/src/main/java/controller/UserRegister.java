package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet("/registeredUser")
public class UserRegister extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().append("Welcome to the user register page, method GET");
        System.out.println("Welcome to the user register page, method GET");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.getWriter().append("Welcome to the user register page, method POST");
        // System.out.println("Welcome to the user register page, method POST");
        String nome = req.getParameter("firstname");
        String cognome = req.getParameter("lastname");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User u = new User(nome,cognome,email,username,password);

        req.setAttribute("user", u);
    }
}
