package org.example.springjdbc.services;

import org.example.springjdbc.models.User;
import org.example.springjdbc.repositories.UserDAO;
import org.example.springjdbc.repositories.UserDAORepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired UserDAORepository db;
    @Autowired @Qualifier("adminUser") ObjectProvider<User> adminUserProvider;
    @Autowired @Qualifier("customUser") ObjectProvider<User> customUserProvider;
    @Autowired @Qualifier("fakeUser")  ObjectProvider<User> fakeUserProvider;

    public User createFakeUser() { return  fakeUserProvider.getObject(); }
    public User createAdminUser() { return  adminUserProvider.getObject(); }

    public User createCustomUser(String firstName, String lastName, Integer age, String city, String email) {
        User user = customUserProvider.getObject();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setCity(city);
        user.setEmail(email);
        return user;
    }

    // JDBC
    public void saveUser(User user) {
        db.createUser(user);
        System.out.println(user.getFirstName() + " " +user.getLastName() + " created!");
    }

    public User getUser(int id) {
        return db.findUser(id);
    }

    public void updateUser(User user) {
        db.updateUser(user);
        System.out.println(user.getFirstName() + " " +user.getLastName() + " modified!");
    }

    public void deleteUser(User user) {
        db.deleteUser(user);
        System.out.println(user.getFirstName() + " " +user.getLastName() + " deleted!");
    }

    public List<User> getAllUsers() {
        return db.findAllUsers();
    }

}
