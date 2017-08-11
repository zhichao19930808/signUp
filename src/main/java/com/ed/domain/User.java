package com.ed.domain;


import java.util.HashMap;
import java.util.Map;

public class User {
    private int id;
    private String userName;
    private String password;
    private String repassword;
    private String email;
    private String birthday;
    private Map<String, String> message = new HashMap<>();

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }

    public Map<String, String> getMessage() {

        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", message=" + message +
                '}';
    }

    public int getId() {

        return id;
    }

    public String getUserName() {

        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRepassword() {
        return repassword;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }
}
