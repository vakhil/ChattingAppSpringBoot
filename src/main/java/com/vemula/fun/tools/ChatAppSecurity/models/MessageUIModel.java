package com.vemula.fun.tools.ChatAppSecurity.models;

import java.sql.Timestamp;

public class MessageUIModel {
    //0 indicates the message was sent from us to someone  and 1 indicates the message came from someone to us
    private int messageDirection;
    private String message;
    private Boolean seen;
    private byte[] imageBlob;
    private String mediaType;
    private String timestamp;
    private String userProfilePicture;
    private String receiveProfilePicture;

    public String getUserProfilePicture() {
        return userProfilePicture;
    }

    public void setUserProfilePicture(String userProfilePicture) {
        this.userProfilePicture = userProfilePicture;
    }

    public String getReceiveProfilePicture() {
        return receiveProfilePicture;
    }

    public void setReceiveProfilePicture(String receiveProfilePicture) {
        this.receiveProfilePicture = receiveProfilePicture;
    }

    public int getMessageDirection() {
        return messageDirection;
    }

    public void setMessageDirection(int messageDirection) {
        this.messageDirection = messageDirection;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public byte[] getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(byte[] imageBlob) {
        this.imageBlob = imageBlob;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
