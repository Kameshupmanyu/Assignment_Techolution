package com.example.techolution.Assignment.entities;



import javax.persistence.*;

@Entity
@Table(name = "my_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;

    private String role;
    private String mobile;

    public User() {
    }

    public User(String userName, String password, String role,String mobile) {
        this.userName = userName;
        this.password = password;
        this.role = role.toUpperCase();
        this.mobile = mobile;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        role = role.toUpperCase();
        this.role = role;
    }
}
