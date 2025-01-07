package com.example.swp391.domain;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private Date dob;

    @Column(columnDefinition = "nvarchar(255)")
    @NotEmpty(message = "àhwoeifoiwejfowejoifj")
    private String name;

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @NotEmpty
    @Size(min = 6, message = "Password must be at least 6 characters in length")
    private String password;

    @Column(columnDefinition = "nvarchar(255)")
    @NotEmpty
    private String address;

    @NotEmpty(message = "Phone cannot be empty")
    private String phoneNumber;

    @Column(columnDefinition = "nvarchar(255)")
    @NotEmpty(message = "Job cannot be empty")
    private String job;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    @Override
    public String toString() {
        return "User [id=" + id + ", dob=" + dob + ", name=" + name + ", username=" + username + ", password="
                + password + ", address=" + address + ", phoneNumber=" + phoneNumber + ", job=" + job + ", role=" + role
                + "]";
    }

}
