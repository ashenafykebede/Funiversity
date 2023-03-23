package com.switchfully.funiversity.webapi.dto;

import com.switchfully.funiversity.domain.ProfessorRepository;
import com.switchfully.funiversity.domain.Role;

public class ProfessorDTO {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final Role role;

    public ProfessorDTO(String id, String firstName, String lastName, String email, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
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
}
