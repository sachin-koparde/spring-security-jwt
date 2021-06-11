package io.springsecurity.springsecurityjwt.user;

import javax.persistence.*;

@Entity
@Table(name = "accessUsers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    @SequenceGenerator(name = "employee_sequence", sequenceName = "EMP_SEQ")
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String roles;

    @Column
    private Boolean active;

    public User() {
    }

    public User(int id, String username, String password, String roles, Boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


}
