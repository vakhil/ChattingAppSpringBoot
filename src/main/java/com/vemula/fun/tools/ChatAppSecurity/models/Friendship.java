package com.vemula.fun.tools.ChatAppSecurity.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="friendship")
public class Friendship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userSender;
    private String userReceipient;
    @Column(name = "blocked", columnDefinition = "BOOLEAN")
    private Boolean blocked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserSender() {
        return userSender;
    }

    public void setUserSender(String userSender) {
        this.userSender = userSender;
    }

    public String getUserReceipient() {
        return userReceipient;
    }

    public void setUserReceipient(String userReceipient) {
        this.userReceipient = userReceipient;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }
}
