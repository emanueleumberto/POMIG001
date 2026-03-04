package dao;

import entities.Company;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class CompanyDAO {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private final static EntityManager em = emf.createEntityManager();

    public static String saveCompany(Company company) {
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
        return "Company has been saved successfully";
    }

    public static Company getCompany(int id) {
        return em.find(Company.class, id);
    }

    public static String deleteCompany(Company company) {
        em.getTransaction().begin();
        em.remove(company);
        em.getTransaction().commit();
        return "Company has been deleted successfully";
    }

    public static List<Company> getAllCompanies() {
        Query query = em.createNamedQuery("Company.findAll");
        return query.getResultList();
    }

}
