package controller;

import entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import services.AuthService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String check = req.getParameter("check");

        try {
            User userLogin = AuthService.login(email, password);
            if(userLogin == null){
                // email non corretta
                req.setAttribute("error", "Email or Password is invalid");
                req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
                return;
            }
            HttpSession session = req.getSession();
            session.setAttribute("userLogin", userLogin);

            if(check != null && check.equals("on")){
                Cookie userLoginCookieEmail = new Cookie("userLoginEmail", userLogin.getEmail());
                Cookie userLoginCookiePass = new Cookie("userLoginPass", userLogin.getPassword());
                userLoginCookieEmail.setMaxAge(60*60*24);
                userLoginCookiePass.setMaxAge(60*60*24);
                resp.addCookie(userLoginCookieEmail);
                resp.addCookie(userLoginCookiePass);
                System.out.println("Cookie: " + userLogin.getEmail());
            }

            resp.sendRedirect(req.getContextPath() + "/");

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }
}
