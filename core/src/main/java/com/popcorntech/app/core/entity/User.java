package com.popcorntech.app.core.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
})

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "password", length = 60)
    private String password;

    @Column(name = "otp", length = 6, nullable = false)
    private String otp;

    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 45, nullable = false)
    private String lastName;

    @Column(name = "mobile", length = 10, nullable = false)
    private String mobile;

    @Column(name = "street", length = 10, nullable = false)
    private String street;

    @Column(name = "city", length = 10, nullable = false)
    private String city;

    @Column(name = "state", length = 10, nullable = false)
    private String state;

    @Column(name = "zip_code", length = 20, nullable = false)
    private String zipCode;

    @Column(name = "id_no", length = 20, nullable = false)
    private String idNO;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private UserStatus userStatus = UserStatus.NOT_VERIFIED;

    @Enumerated(EnumType.STRING)
    @Column(name = "id_type", nullable = false)
    private IDType idType = IDType.NATIONAL_ID;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "role",nullable = false)
    private Set<String> roles = new HashSet<String>();

    public User() {
    }

    public IDType getIdType() {
        return idType;
    }

    public User setIdType(IDType idType) {
        this.idType = idType;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public User setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public User setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public User setState(String state) {
        this.state = state;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public User setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getOtp() {
        return otp;
    }

    public User setOtp(String otp) {
        this.otp = otp;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public User setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public User setRoles(Set<String> roles) {
        this.roles = roles;
        return this;
    }
}
