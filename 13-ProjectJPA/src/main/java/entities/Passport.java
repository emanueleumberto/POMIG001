package entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "passports")
@NamedQuery(name = "Passport.findAll", query = "SELECT p FROM Passport p")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id" , nullable = false)
    private int id;
    @Column(name = "number_passport",  nullable = false)
    private int numberPassport;
    @Column(name = "passport_date",  nullable = false)
    private LocalDate passportDate;

    @OneToOne
    @JoinColumn(name = "user_id",  nullable = false, unique = true)
    private User user;

    public Passport() {}

    public Passport(int numberPassport, LocalDate passportDate, User user) {
        this.numberPassport = numberPassport;
        this.passportDate = passportDate;
        this.user = user;
    }
    public int getId() {
        return id;
    }
    public int getNumberPassport() {
        return numberPassport;
    }
    public void setNumberPassport(int numberPassport) {
        this.numberPassport = numberPassport;
    }
    public LocalDate getPassportDate() {
        return passportDate;
    }
    public void setPassportDate(LocalDate passportDate) {
        this.passportDate = passportDate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", numberPassport=" + numberPassport +
                ", passportDate=" + passportDate +
                ", user=" + user +
                '}';
    }
}
