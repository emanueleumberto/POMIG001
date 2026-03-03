package controller;

import dao.PassportDAO;
import dao.UserDAO;
import entities.Address;
import entities.Passport;
import entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/test")
public class TestDispatcher extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Address address = new Address("Via Marconi 1", "Roma", "Italia");
        //User user = new User("Mario", "Rossi", 45, "m.rossi@example.com", "Pa$$w0rd!", address);
        //UserDAO.saveUser(user);

        //User user = UserDAO.getUser(1);
        //System.out.println(user);
        //user.getAddress().setCity("New York");
        //user.setAge(99);
        //UserDAO.saveUser(user);
        //UserDAO.deleteUser(user);

        //Passport passport = new Passport(1, LocalDate.now(), user);
        //PassportDAO.savePassport(passport);

        //Passport passport = PassportDAO.getPassport(1);
        //System.out.println(passport);

        //PassportDAO.deletePassport(passport);

        //Address address = new Address("Piazza del Plebiscito 22", "Napoli", "Italia");
        //User user = new User("Giuseppe", "Verdi", 21, "g.verdi@example.com", "Pa$$w0rd!", address);
        //UserDAO.saveUser(user);
        //Passport passport = new Passport(2, LocalDate.now(), user);
        //PassportDAO.savePassport(passport);

        //UserDAO.deleteUser(UserDAO.getUser(1));
    }
}
