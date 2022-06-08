
package Entities;

import java.util.HashMap;


public class User {
    private String userName;
    private String userPublicName;
    private String pass;
    private String userBirth;
    private String userMail;
    private String userSecret;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPublicName() {
        return userPublicName;
    }

    public void setUserPublicName(String userPublicName) {
        this.userPublicName = userPublicName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserSecret() {
        return userSecret;
    }

    public void setUserSecret(String userSecret) {
        this.userSecret = userSecret;
    }

    public User() {   
    }
    
}