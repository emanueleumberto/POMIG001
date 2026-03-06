package org.example.springjdbc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private String email;

    public User(String firstName, String lastName, Integer age, String city, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.email = email;
    }

//    CREATE TABLE `pomig001_spring_jdbc`.`users` (
//                `user_id` INT NOT NULL AUTO_INCREMENT,
//                `firstname` VARCHAR(45) NOT NULL,
//                `lastname` VARCHAR(45) NOT NULL,
//                `age` INT NULL,
//                `city` VARCHAR(45) NULL,
//                `email` VARCHAR(45) NOT NULL,
//                PRIMARY KEY (`user_id`),
//                UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
}
