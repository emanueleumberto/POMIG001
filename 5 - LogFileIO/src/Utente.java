public class Utente {

    private static int count = 1;
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private String city;
    private String email;
    private String password;
    private boolean active;

    public Utente(String firstname, String lastname, int age, String city, String email, String password) {
        this.id = count++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.city = city;
        this.email = email;
        this.password = password;
        this.active = false;
    }

    public Utente(int id, String firstname, String lastname, int age, String city, String email, String password, boolean active) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.city = city;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public int getId() {
        return id;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
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
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
