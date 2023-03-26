package com.switchfully.funiversity.service.professor;

import com.switchfully.funiversity.domain.professor.Professor;
import com.switchfully.funiversity.domain.professor.ProfessorRepository;
import com.switchfully.funiversity.webapi.dto.professor.AddProfessorDTO;
import com.switchfully.funiversity.webapi.dto.professor.ProfessorDTO;
import com.switchfully.funiversity.webapi.dto.professor.UpdateProfessorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    private ProfessorRepository professorRepository;
    private ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepository profRepo, ProfessorMapper profMapper) {
        this.professorRepository = profRepo;
        this.professorMapper = profMapper;
    }

    public ProfessorDTO save(AddProfessorDTO addProfessorDTO) {
        Professor professor = professorMapper.toDomain(addProfessorDTO);
        return professorMapper.toDTO(professorRepository.save(professor));
    }


    public List<ProfessorDTO> getAllProfessors() {
        return professorRepository.getAllProfessors().stream().map(professor -> professorMapper.toDTO(professor)).collect(Collectors.toList());
    }

    public ProfessorDTO getProfessorById(String id) {
        return professorMapper.toDTO(professorRepository.getProfessorById(id));
    }
    public ProfessorDTO updateProfessorById(UpdateProfessorDTO updateProfessorDTO, String id) {
            var newProfData= professorMapper.toDomain(updateProfessorDTO);
            var updatedProf = professorRepository.updateProfessor(id,newProfData);

       return professorMapper.toDTO(updatedProf);
    }

    public void deleteProfessor(String id) {
        professorRepository.deleteProfessor(id);
    }
}
