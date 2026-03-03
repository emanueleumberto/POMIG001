package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
@NamedQuery(name = "User.login", query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int id;

    @Column(name = "firstname",  nullable = false)
    private String name;
    @Column(name = "lastname",   nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, length = 10)
    private String password;

    @Embedded
    private Address address;

    // Solo se voglio una relazione bidirezionale
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Passport passport;


    public User() {}

    public User(String name, String lastName, int age, String email, String password, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Passport getPassport() {
        return passport;
    }
    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", passport=" + passport.getNumberPassport() +
                '}';
    }
}
