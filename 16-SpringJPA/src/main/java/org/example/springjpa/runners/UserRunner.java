package org.example.springjpa.runners;

import org.example.springjpa.models.Address;
import org.example.springjpa.models.User;
import org.example.springjpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {

//         Address address = new Address("Via Roma 1", "Roma", "Italia");
//
//         User u1 = userService.createCustomUser("Giuseppe", "Verdi", 45, "g.verdi@example.com", address);
//         User u2 = userService.createAdminUser();
//         User u3 = userService.createFakeUser();
//
//         userService.saveUser(userService.createAdminUser());
//         userService.saveUser(userService.createFakeUser());
//         User user = userService.findUser(3);
//        user.setEmail(
//                user.getFirstname().toLowerCase().charAt(0) +
//                        "." + user.getLastname().toLowerCase() +
//                        "@example.com");
//        userService.saveUser(user);

//        userService.removeUser(userService.findUser(2));

//        userService.findAll().forEach(System.out::println);
//        userService.getByEmail("g.guerra@example.com").forEach(System.out::println);

//            userService.getByAgeBetween(45,60).forEach(System.out::println);

    }
}
