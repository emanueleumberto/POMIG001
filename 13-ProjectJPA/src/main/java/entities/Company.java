package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    private int id;
    @Column(name = "company_name",  nullable = false)
    private String companyName;

    @Embedded
    private Address companyAddress;

    // Solo se voglio una relazione bidirezionale
    @OneToMany(mappedBy = "company")
    List<User> employees;

    public Company() {}

    public Company(String companyName, Address companyAddress) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.employees = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public Address getCompanyAddress() {
        return companyAddress;
    }
    public void setCompanyAddress(Address companyAddress) {
        this.companyAddress = companyAddress;
    }
    public List<User> getEmployees() {
        return employees;
    }
    public void setEmployees(List<User> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyAddress=" + companyAddress +
                ", employees=" + employees.size() +
                '}';
    }
}
