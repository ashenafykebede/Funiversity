package com.switchfully.funiversity.domain;

import java.util.Objects;
import java.util.UUID;

public class Professor {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final Role role;

    public Professor(String firstName, String lastName, String email, String password) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = Role.PROFESSOR;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
    public boolean isCorrectPassword(String passwordToBeChecked){
        return this.password.equals(passwordToBeChecked);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id) && Objects.equals(firstName, professor.firstName) && Objects.equals(lastName, professor.lastName) && Objects.equals(email, professor.email) && Objects.equals(password, professor.password) && role == professor.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, role);
    }

    public boolean hasAccessTo(Feature feature) {
        return role.canAccess(feature);
    }
}
