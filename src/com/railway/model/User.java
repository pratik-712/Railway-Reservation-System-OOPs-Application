package com.railway.model;

public class User {

    private int userId;
    private String name;
    private String email;
    private String phoneNumber;

    public User(int userId, String name, String email, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void displayUserDetails() {

        System.out.println("\n----- USER DETAILS -----");
        System.out.println("User ID       : " + userId);
        System.out.println("Name          : " + name);
        System.out.println("Email         : " + email);
        System.out.println("Phone Number  : " + phoneNumber);
    }
}