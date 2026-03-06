package org.example.springjdbc.repositories;

import org.example.springjdbc.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setAge(rs.getInt("age"));
        user.setCity(rs.getString("city"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}
