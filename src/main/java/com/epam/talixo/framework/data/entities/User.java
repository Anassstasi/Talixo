package com.epam.talixo.framework.data.entities;

public class User {

    private String firstName;
    private String lastName;
    private String prefixPhone;
    private String phoneNumber;
    private String email;
    private String password;
    private String address;

    public User(String firstName, String lastName, String prefixPhone, String phoneNumber, String email, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.prefixPhone = prefixPhone;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrefixPhone() {
        return prefixPhone;
    }

    public void setPrefixPhone(String prefixPhone) {
        this.prefixPhone = prefixPhone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}