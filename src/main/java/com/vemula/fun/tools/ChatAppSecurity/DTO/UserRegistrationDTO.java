package com.vemula.fun.tools.ChatAppSecurity.DTO;

import org.springframework.web.multipart.MultipartFile;

public class UserRegistrationDTO {
    private String username;
    private String password;
    private MultipartFile file;


    public UserRegistrationDTO(){};
    public UserRegistrationDTO(String username, String password, MultipartFile profilePicture) {
        this.username = username;
        this.password = password;
        this.file = profilePicture;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
