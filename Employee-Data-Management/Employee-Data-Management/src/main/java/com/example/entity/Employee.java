package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.UUID;

@Document
public class Employee {

    @Id
    private String id;
    private String employeeName;
    private String phoneNumber;
    private String reportsTo;
    private String profileImage;

    public Employee(String employeeName, String phoneNumber, String reportsTo, String profileImage) {
        this.id = UUID.randomUUID().toString();
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.reportsTo = reportsTo;
        this.profileImage = profileImage;
    }

    public Employee() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
