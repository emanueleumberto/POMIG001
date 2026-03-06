package org.example.springjdbc.configurations;

import com.github.javafaker.Faker;
import org.example.springjdbc.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("application.properties")
public class UserConfiguration {

    @Value("${user.admin.name}") private String adminName;
    @Value("${user.admin.lastname}") private String adminLastname;
    @Value("${user.admin.age}") private Integer adminAge;
    @Value("${user.admin.city}") private String adminCity;
    @Value("${user.admin.email}") private String adminEmail;

    @Bean
    @Scope("singleton")
    public User adminUser() {
        return new User(adminName, adminLastname, adminAge, adminCity, adminEmail);
    }

    @Bean("customUser")
    @Scope("prototype")
    public User customUser() { return new User(); }

    @Bean
    @Scope("prototype")
    public User fakeUser() {
        Faker fake =  new Faker();
//        return new User(
//                fake.name().firstName(),
//                fake.name().lastName(),
//                fake.number().numberBetween(18,70),
//                fake.address().cityName(),
//                fake.internet().emailAddress()
//        );

        // Soluzione con il Builder
        return User.builder()
                .firstName(fake.name().firstName())
                .lastName(fake.name().lastName())
                .age(fake.number().numberBetween(18,70))
                .city(fake.address().cityName())
                .email(fake.internet().emailAddress())
                .build();
    }

}
