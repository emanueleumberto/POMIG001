package org.example.springjdbc.repositories;

import org.example.springjdbc.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAORepository {

    // CRUD
    public void createUser(User user);
    public User findUser(int id);
    public void updateUser(User user);
    public void deleteUser(User user);

    public List<User> findAllUsers();

}
