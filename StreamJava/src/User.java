import java.util.HashSet;
import java.util.Set;

public class User {

    private String firstname;
    private String lastname;
    private String city;
    private int age;
    private Set<String> hobby;

    public User(String firstname, String lastname, String city, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
        this.hobby = new HashSet<>();
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Set<String> getHobby() {
        return hobby;
    }
    public void setHobby(Set<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", hobby=" + hobby.size() +
                '}';
    }
}
