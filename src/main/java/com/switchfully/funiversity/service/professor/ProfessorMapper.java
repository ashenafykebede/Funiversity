package com.switchfully.funiversity.service.professor;

import com.switchfully.funiversity.domain.professor.Professor;
import com.switchfully.funiversity.webapi.dto.professor.AddProfessorDTO;
import com.switchfully.funiversity.webapi.dto.professor.ProfessorDTO;
import com.switchfully.funiversity.webapi.dto.professor.UpdateProfessorDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<ProfessorDTO> toDTO(List<Professor> professors){
        return professors.stream().map(this::toDTO).collect(Collectors.toList());
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
