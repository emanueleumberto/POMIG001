package org.example.springjpa.repositories;

import org.example.springjpa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAORepository extends JpaRepository<User, Long> {

    public List<User> findByEmail(String email);
    public List<User> findByAgeBetween(int min, int max);
    public List<User> findByFirstnameAndLastname(String firstname, String lastname);
    public List<User> findByEmailNot(String email);
    public List<User> findByEmailLike(String parteEmail);
    public boolean existsByEmail(String email);

//    @Query("SELECT u FROM User u WHERE u.firstname.length > :p")
//    public List<User> findByFirstnameLength(@Param("p") int p);

}
