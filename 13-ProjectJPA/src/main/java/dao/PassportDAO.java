package dao;

import entities.Passport;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class PassportDAO {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private final static EntityManager em = emf.createEntityManager();

    public static String savePassport(Passport passport) {
        em.getTransaction().begin();
        em.persist(passport);
        em.getTransaction().commit();
        return "Passport has been saved successfully";
    }

    public static Passport getPassport(int id) {
        return em.find(Passport.class, id);
    }

    public static String deletePassport(Passport passport) {
        em.getTransaction().begin();
        em.remove(passport);
        em.getTransaction().commit();
        return "Passport has been deleted successfully";
    }

    public static List<Passport> getAllPassports() {
        Query query = em.createNamedQuery("Passport.findAll");
        return query.getResultList();
    }

}
