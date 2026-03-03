package services;

import dao.UserDAO;
import entities.Address;
import entities.User;

import java.sql.SQLException;

public class AuthService {

    public static String register(
            String firstname,
            String lastname,
            String street,
            String city,
            String state,
            int age,
            String email,
            String password) throws SQLException, ClassNotFoundException {

        if(firstname.isEmpty() || lastname.isEmpty() || city.isEmpty() || street.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return "Please fill all the fields";
        } else if(UserDAO.getUserByEmail(email).size()>0){
            return "Email already exists";
        } else if (password.length() > 10) {
            return "Password too long";
        } else {
            Address address = new Address(street, city, state);
            return UserDAO.saveUser(new User(firstname, lastname, age, email, password, address));
        }

    }

    public static User login(String email, String password) throws SQLException, ClassNotFoundException {

        if(email.isEmpty() || password.isEmpty()) {
            return null;
        }  else {
            return UserDAO.getUserLogin(email, password);
        }

    }

}
