package com.switchfully.funiversity.webapi.dto;

import com.switchfully.funiversity.domain.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    public ProfessorDTO toDTO(Professor professor){
        return new ProfessorDTO(
                professor.getId(),
                professor.getFirstName(),
                professor.getLastName(),
                professor.getEmail(),
                professor.getPassword(),
                professor.getRole()
                );
    }
    public Professor toDomain(ProfessorDTO professorDTO){
        return new Professor(
                professorDTO.getFirstName(),
                professorDTO.getLastName(),
                professorDTO.getEmail(),
                professorDTO.getPassword(),
                professorDTO.getRole());
    }
}
