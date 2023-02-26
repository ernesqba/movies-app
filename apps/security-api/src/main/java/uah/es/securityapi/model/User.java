package uah.es.securityapi.model;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "security_db")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "enable")
    private boolean enable;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Critic> critics;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_has_authorities", joinColumns = {
            @JoinColumn(name = "Users_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "Authorities_id", referencedColumnName = "id") })
    private List<Role> roles;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setpassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<Critic> getCritics() {
        return critics;
    }

    public void setCritics(List<Critic> critics) {
        this.critics = critics;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return enable == user.enable && Objects.equals(id, user.id)
                && Objects.equals(username, user.username)
                && Objects.equals(password, user.password)
                && Objects.equals(email, user.email)
                && Objects.equals(critics, user.critics)
                && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, enable, critics, roles);
    }
}