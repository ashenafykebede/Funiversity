package com.switchfully.funiversity.service;

import com.switchfully.funiversity.domain.Professor;
import com.switchfully.funiversity.domain.ProfessorRepository;
import com.switchfully.funiversity.webapi.dto.ProfessorDTO;
import com.switchfully.funiversity.webapi.dto.ProfessorMapper;
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

    public ProfessorDTO save(ProfessorDTO professorToSave) {
        Professor professor = professorMapper.toDomain(professorToSave);
        return professorMapper.toDTO(professorRepository.save(professor));
    }


    public List<ProfessorDTO> getAllProfessors() {
        return professorRepository.getAllProfessors().stream().map(professor -> professorMapper.toDTO(professor)).collect(Collectors.toList());
    }

    public ProfessorDTO getProfessorById(String id) {
        return professorMapper.toDTO(professorRepository.getProfessorById(id));
    }
    public ProfessorDTO updateProfessorById(ProfessorDTO newProfDataDTO, String id) {
            var newProfData= professorMapper.toDomain(newProfDataDTO);
            var updatedProf = professorRepository.updateProfessor(id,newProfData);

       return professorMapper.toDTO(updatedProf);
    }

    public void deleteProfessor(String id) {
        professorRepository.deleteProfessor(id);
    }
}
