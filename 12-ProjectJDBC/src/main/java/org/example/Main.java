package org.example;

import java.sql.SQLException;

public class Main
{
    public static void main( String[] args ) {
        try {
            DBConnection db1 = DBConnection.getInstance();

            // User u = new User("Giuseppe", "Verdi", "Milano", 41, "g.verdi@example.com");
            // User u = new User("Francesca", "Neri", "Firenze", 23, "f.neri@example.com");
            // db.createUser(u);

            // User u = db.findUserById(2);
            // System.out.println(u);

            // u.setCity("Berlin");
            // u.setAge(42);
            // db.updateUser(u);

            // db.deleteUser(u);

            // db.findAllUsers().forEach(System.out::println);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
