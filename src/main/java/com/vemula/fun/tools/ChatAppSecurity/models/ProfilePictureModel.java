package com.vemula.fun.tools.ChatAppSecurity.models;


public class ProfilePictureModel {

    String sender;
    String receive;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public ProfilePictureModel(String sender, String receive) {
        this.sender = sender;
        this.receive = receive;
    }
}
