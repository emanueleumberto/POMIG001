package com.example.spring_intro.runners;

import com.example.spring_intro.classes.User;
import com.example.spring_intro.configurations.UserConfiguration;
import com.example.spring_intro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class UserRunner implements CommandLineRunner {

    private List<User> users;
    @Autowired UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("User Runner...");

        // Runner -> Service -> Configuration -> Bean -> Class

        User admin = userService.createAdminUser();
        User user1 = userService.createCustomUser("Antonio", "Bianchi", 59, "Torino", "a.bianchi@example.com");
        User user2 = userService.createCustomUser("Giuseppe", "Verdi", 21, "Milano", "g.verdi@example.com");
        User user3 = userService.createCustomUser("Francesca", "Neri", 32, "Napoli", "f.neri@example.com");
        User fake1 = userService.createFakeUser();
        User fake2 = userService.createFakeUser();
        User fake3 = userService.createFakeUser();

        users = List.of(admin, user1,user2,user3,fake1,fake2,fake3);
        users.forEach(System.out::println);
    }










}
