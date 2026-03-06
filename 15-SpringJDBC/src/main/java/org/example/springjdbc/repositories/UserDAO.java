package org.example.springjdbc.repositories;

import org.example.springjdbc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAO implements UserDAORepository {

    @Autowired JdbcTemplate jdbc;

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO users (firstname, lastname, age, city, email) " +
                     "VALUES (?, ?, ?, ?, ?)";
        jdbc.update(
                sql,
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getCity(),
                user.getEmail());
    }

    @Override
    public User findUser(int id) {
        String sql = "SELECT * FROM users WHERE user_id = ?;";
        return jdbc.queryForObject(sql, new UserRowMapper(), id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET " +
                     "firstname=?, lastname=?, age=?, city=?, email=? " +
                     "WHERE user_id=?;";
        jdbc.update(sql,
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getCity(),
                user.getEmail(),
                user.getId());
    }

    @Override
    public void deleteUser(User user) {
        String sql =  "DELETE FROM users WHERE user_id = ?;";
        jdbc.update(sql,user.getId());
    }

    @Override
    public List<User> findAllUsers() {
        String sql = "SELECT * FROM users;";
        return jdbc.query(sql, new UserRowMapper());
    }
}
