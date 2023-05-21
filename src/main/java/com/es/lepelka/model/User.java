package com.es.lepelka.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Table(name = "users")
public class User {
    @Id
    @Column(name = "personnel_number")
    @Pattern(regexp = "\\d{6}", message = "Табельный номер должен состоять из 6 цифр")
    private String personnelNumber;

    @Size(max = 50)
    @Column(name = "first_name")
    @NotBlank(message = "Поле не должно быть пустым")
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name")
    @NotBlank(message = "Поле не должно быть пустым")
    private String lastName;


    @Size(max = 100)
    @NotBlank(message = "Поле не должно быть пустым")
    private String password;

    private boolean enabled;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private List<Authority> authorities = new ArrayList<>();

    public User() {
    }

    public User(String personnelNumber, String firstName, String lastName, String password, boolean enabled, List<Authority> authorities) {
        this.personnelNumber = personnelNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public User(String personnelNumber, String firstName, String lastName, String password, boolean enabled) {
        this.personnelNumber = personnelNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.personnelNumber = personnelNumber;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
