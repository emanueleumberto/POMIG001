package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private int id;
    @Column(name = "course_name",  nullable = false)
    private String courseName;
    @Column(nullable = false)
    private int hour;

    // Solo se voglio una relazione bidirezionale
    @ManyToMany(mappedBy = "courses")
    private List<User> userList = new ArrayList<>();

    public Course() {}

    public Course(String courseName, int hour) {
        this.courseName = courseName;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public List<User> getUserList() {
        return userList;
    }
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", hour=" + hour +
                ", userList=" + userList.size() +
                '}';
    }
}
