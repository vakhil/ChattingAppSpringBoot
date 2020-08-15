package com.vemula.fun.tools.ChatAppSecurity.models;

public class FriendNameProfile {
    String friendName;
    String profilePicture;

    public FriendNameProfile(String friendName, String profilePicture) {
        this.friendName = friendName;
        this.profilePicture = profilePicture;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
