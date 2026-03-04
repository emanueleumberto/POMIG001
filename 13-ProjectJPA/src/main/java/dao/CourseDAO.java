package dao;

import entities.Company;
import entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class CourseDAO {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private final static EntityManager em = emf.createEntityManager();

    public static String saveCourse(Course course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        return "Course has been saved successfully";
    }

    public static Course getCourse(int id) {
        return em.find(Course.class, id);
    }

    public static String deleteCourse(Course course) {
        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
        return "Course has been deleted successfully";
    }

    public static List<Course> getAllCourse() {
        Query query = em.createNamedQuery("Course.findAll");
        return query.getResultList();
    }

}
