package com.example.user.usbankapitest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContactDetailsPojo {
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("address")
    @Expose
    private AddressPojo address;
    @SerializedName("phoneNumber")
    @Expose
    private List<PhoneNumberPojo> phoneNumber = null;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public AddressPojo getAddress() {
        return address;
    }

    public void setAddress(AddressPojo address) {
        this.address = address;
    }

    public List<PhoneNumberPojo> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<PhoneNumberPojo> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
