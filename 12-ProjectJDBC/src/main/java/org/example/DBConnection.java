package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "pomig001jdbc";
    private String driver = "com.mysql.jdbc.Driver";
    private Connection conn;
    private Statement st;
    private static DBConnection instance;

    private DBConnection() throws SQLException {
        conn = DriverManager.getConnection(url,user,pass);
        st = conn.createStatement();
        createDatabase();
        createTableUsers();
    }

    private void createDatabase() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
        st.executeUpdate(sql);
        System.out.println("Database " + dbName + " connected successfully.");
        conn = DriverManager.getConnection(url+dbName,user,pass);
        st = conn.createStatement();
    }

    private void createTableUsers() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                " user_id INT NOT NULL AUTO_INCREMENT," +
                " firstname VARCHAR(25) NOT NULL," +
                " lastname VARCHAR(25) NOT NULL," +
                " city VARCHAR(25) NULL," +
                " age INT UNSIGNED NULL," +
                " email VARCHAR(50) NOT NULL," +
                " CONSTRAINT pk_utente PRIMARY KEY(user_id)," +
                " CONSTRAINT uk_email UNIQUE(email)" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table Users created successfully.");
    }

    // CRUD -> Create Read Update Delete

    public void createUser(User user) throws SQLException {
//        String sql = "INSERT INTO users (firstname, lastname, city, age, email) " +
//                " VALUES  ('"+user.getFirstname()+"'," +
//                " '"+user.getLastname()+"', '"+user.getCity()+"'," +
//                " "+user.getAge()+", '"+user.getEmail()+"');";
//        st.executeUpdate(sql);

        String sql = "INSERT INTO users (firstname, lastname, city, age, email) " +
                " VALUES (?, ?, ?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getFirstname());
        ps.setString(2, user.getLastname());
        ps.setString(3, user.getCity());
        ps.setInt(4, user.getAge());
        ps.setString(5, user.getEmail());
        ps.executeUpdate();
        System.out.println("User " + user.getFirstname() + " " + user.getLastname() + " created successfully.");
    }

    public User findUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery(); // null | row
        if(rs.next()){
            int user_id = rs.getInt("user_id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String city = rs.getString("city");
            int age = rs.getInt("age");
            String email = rs.getString("email");

            return new User(user_id, firstname, lastname, city, age, email);
        }
        return null;
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET firstname=?,lastname=?,city=?,age=?,email=?  WHERE user_id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getFirstname());
        ps.setString(2, user.getLastname());
        ps.setString(3, user.getCity());
        ps.setInt(4, user.getAge());
        ps.setString(5, user.getEmail());
        ps.setInt(6, user.getUser_id());
        ps.executeUpdate();
        System.out.println("User " + user.getFirstname() + " " + user.getLastname() + " modified successfully.");
    }

    public void deleteUser(User user) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, user.getUser_id());
        ps.executeUpdate();
        System.out.println("User " + user.getFirstname() + " " + user.getLastname() + " deleted successfully.");
    }

    public List<User> findAllUsers() throws SQLException {
        String sql = "SELECT * FROM users;";
        PreparedStatement ps = conn.prepareStatement(sql);

        List<User> users = new ArrayList<>();
        ResultSet rs = ps.executeQuery(); // null | rows
        while(rs.next()){
            int user_id = rs.getInt("user_id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String city = rs.getString("city");
            int age = rs.getInt("age");
            String email = rs.getString("email");

            users.add(new User(user_id, firstname, lastname, city, age, email));
        }
        return users;
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
}
