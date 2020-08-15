package com.vemula.fun.tools.ChatAppSecurity.models;

import javax.persistence.*;

import static java.sql.Types.BINARY;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name = "username")
    private String userName;
    private String password;
    private String roles;
    private boolean active;
    @Lob
    @Column(name = "profilepicture",length=100000)
    private byte[] profilePicture;


    public User(){}
    public User(String userName,String password, byte[] profilePicture,String roles, Boolean active) {
        this.userName = userName;
        this.password = password;
        this.profilePicture = profilePicture;
        this.roles = roles;
        this.active = active;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
}
