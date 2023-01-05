package com.team5.ACMEFlix.helpers;

import com.team5.ACMEFlix.domain.Address;
import com.team5.ACMEFlix.domain.CreditCard;

import java.util.List;

public class RegisterForm {
    private String email;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String confirmPassword;
    private String phoneNo;
    private List<Address> address;
    private List<CreditCard> creditCards;

    public RegisterForm() {
    }

    public RegisterForm(String email, String username, String firstname, String lastname, String password, String confirmPassword, String phoneNo, List<Address> address, List<CreditCard> creditCards) {
        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phoneNo = phoneNo;
        this.address = address;
        this.creditCards = creditCards;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
