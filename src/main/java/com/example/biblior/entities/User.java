package com.example.biblior.entities;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "USERS")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name="ROLE",nullable = false)
    private final String role = this.getClass().getSimpleName();
    @Column(name="FIRST_NAME", nullable = false)
    @NotBlank(message = "First name cannot be empty")
    private String firstName;
    @Column(name="LAST_NAME", nullable = false)
    @NotBlank(message = "Last name cannot be empty")
    private String lastName;
    @Column(name="EMAIL", nullable = false, unique = true)
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email is not correct")
    private String email;
    @Column(name = "PASSWORD", nullable = false)
    @NotBlank(message = "Password cannot be empty")
    private String password;
    @Column(name="FAILED_BORROWS")
    private int failedBorrows = 0;
    @ManyToMany
    @JoinTable(
            name = "USER_BORROWES",
            joinColumns = {@JoinColumn(name="USER_ID")},
            inverseJoinColumns = {@JoinColumn(name="PRINTED_ID")}
    )
    private Set<Printed> borrows = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFailedBorrows() {
        return failedBorrows;
    }
    public void borrowPunished(){
        this.failedBorrows++;
    }

}
