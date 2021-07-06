package com.example.vuga.Models;

public class Users {
    String profilepic , username, mail ,password, userId ,lastMessage,status ;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Users(String profilepic, String username, String mail, String userId, String password, String lastMessage) {
        this.profilepic = profilepic;
        this.username = username;
        this.mail = mail;
        this.password = password;


        this.userId = userId;
        this.lastMessage = lastMessage;
    }
    public Users(){}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //sign-up constructor
    public Users( String username, String mail, String password) {

        this.username = username;
        this.mail = mail;
        this.password = password;

    }


    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }


}
