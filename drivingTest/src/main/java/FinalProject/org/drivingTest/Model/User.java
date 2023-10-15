package FinalProject.org.drivingTest.Model;

import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "Users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String username;

    private String password;

    public User(int id, String username, String password) {
        this.userId = id;
        this.username = username;
        this.password = hashPassword(password);
    }

    public User(String username, String password) {
        this.username = username;
        this.password = hashPassword(password);
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // You can adjust this based on your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // You can adjust this based on your requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // You can adjust this based on your requirements
    }

    @Override
    public boolean isEnabled() {
        return true; // You can adjust this based on your requirements
    }

}
