package com.example.spring_intro.services;

import com.example.spring_intro.classes.User;
import com.example.spring_intro.configurations.UserConfiguration;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired @Qualifier("adminUser") ObjectProvider<User> adminUserProvider;
    @Autowired @Qualifier("customUser") ObjectProvider<User> customUserProvider;
    @Autowired @Qualifier("fakeUser")  ObjectProvider<User> fakeUserProvider;

    public User createAdminUser() {
        return adminUserProvider.getObject();
    }

    public User createCustomUser(String firstName, String lastName,  int age, String city, String email) {
        User user = customUserProvider.getObject();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setCity(city);
        user.setEmail(email);
        return user;
    }

    public User createFakeUser() {
        return fakeUserProvider.getObject();
    }


}
