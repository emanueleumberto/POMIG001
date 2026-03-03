package controller;

import dao.UserDAO;
import entities.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User userLogin = (User) session.getAttribute("userLogin");
        if(userLogin == null){
            Cookie[] cookies = req.getCookies();
            for (Cookie c : cookies) {
                if(c.getName().equals("userLoginEmail")){
                    String email = c.getValue();
                    String pass = "";
                    if(c.getName().equals("userLoginPass")){
                        pass = c.getValue();
                    }
                    if(!email.isEmpty() && !pass.isEmpty()) {
                        userLogin = UserDAO.getUserLogin(email, pass);
                        session.setAttribute("userLogin", userLogin);

                        req.setAttribute("userLogin", userLogin);
                        req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
                        return;
                    }
                }
            }
            resp.sendRedirect("login");
            return;
        }

        req.setAttribute("userLogin", userLogin);
        req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
    }
}
