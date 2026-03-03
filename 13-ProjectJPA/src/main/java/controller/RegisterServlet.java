package controller;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AuthService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        int age = Integer.parseInt(req.getParameter("age"));
        String street = req.getParameter("street");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            String msg = AuthService.register(firstname, lastname, street, city, state, age, email, password);
            if (msg == "User has been saved successfully") {
                req.setAttribute("success", msg);
                req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
                return;
            } else {
                req.setAttribute("error", msg);
                req.getRequestDispatcher("jsp/register.jsp").forward(req, resp);
                return;
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }


    }
}
