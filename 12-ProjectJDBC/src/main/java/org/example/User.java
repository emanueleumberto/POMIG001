package org.example;

public class User {

    private int user_id;
    private String firstname;
    private String lastname;
    private String city;
    private int age;
    private String email;

    public User(String firstname, String lastname, String city, int age, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
        this.email = email;
    }

    public User(int user_id, String firstname, String lastname, String city, int age, String email) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getCity() {
        return city;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
