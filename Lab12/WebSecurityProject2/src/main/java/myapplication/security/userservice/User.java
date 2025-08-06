package myapplication.security.userservice;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        roles.add(new Role(role));
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}