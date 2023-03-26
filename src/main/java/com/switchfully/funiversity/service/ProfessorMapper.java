package com.switchfully.funiversity.service;

import com.switchfully.funiversity.domain.Professor;
import com.switchfully.funiversity.webapi.dto.AddProfessorDTO;
import com.switchfully.funiversity.webapi.dto.ProfessorDTO;
import com.switchfully.funiversity.webapi.dto.UpdateProfessorDTO;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    public ProfessorDTO toDTO(Professor professor){
        return new ProfessorDTO(
                professor.getId(),
                professor.getFirstName(),
                professor.getLastName(),
                professor.getEmail()
                );
    }
    public Professor toDomain(AddProfessorDTO AddprofessorDTO) {
        return new Professor(
                AddprofessorDTO.getFirstName(),
                AddprofessorDTO.getLastName(),
                AddprofessorDTO.getEmail(),
                AddprofessorDTO.getPassword()
        );
    }
    public Professor toDomain(UpdateProfessorDTO updateProfessorDTO) {
        return new Professor(
                updateProfessorDTO.getFirstName(),
                updateProfessorDTO.getLastName(),
                updateProfessorDTO.getEmail(),
                updateProfessorDTO.getPassword()
        );
    }
}
