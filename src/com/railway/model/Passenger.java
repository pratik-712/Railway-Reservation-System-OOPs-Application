package com.railway.model;

public class Passenger extends User {

    private int passengerId;
    private int age;
    private String gender;

    public Passenger(
            int userId,
            String name,
            String email,
            String phoneNumber,
            int passengerId,
            int age,
            String gender) {

        super(userId, name, email, phoneNumber);

        this.passengerId = passengerId;
        this.age = age;
        this.gender = gender;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void displayPassengerDetails() {

        displayUserDetails();

        System.out.println("Passenger ID  : " + passengerId);
        System.out.println("Age           : " + age);
        System.out.println("Gender        : " + gender);
    }
}