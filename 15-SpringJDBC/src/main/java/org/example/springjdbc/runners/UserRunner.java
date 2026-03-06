package org.example.springjdbc.runners;

import org.example.springjdbc.models.User;
import org.example.springjdbc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRunner implements CommandLineRunner {

    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {

        // Runner -> Service -> Repository -> Configuration -> Bean -> Class

        //User admin = userService.createAdminUser();
        //userService.saveUser(admin);
        //User user = userService.createCustomUser("Francesca", "Neri", 21, "Roma", "f.neri@example.com");
        //userService.saveUser(user);
        //User fake = userService.createFakeUser();
        //userService.saveUser(fake);

        //User user = userService.getUser(1);
        //user.setFirstName("Jack");
        //userService.updateUser(user);

        //userService.deleteUser(user);

        userService.getAllUsers().forEach(System.out::println);

    }
}
