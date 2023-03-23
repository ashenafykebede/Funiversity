package com.switchfully.funiversity.webapi;

import com.switchfully.funiversity.domain.Feature;
import com.switchfully.funiversity.service.security.SecurityService;
import com.switchfully.funiversity.service.ProfessorService;
import com.switchfully.funiversity.webapi.dto.ProfessorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "professors")
public class ProfessorController {
    private final Logger mylogger = LoggerFactory.getLogger(ProfessorController.class);
    private final ProfessorService professorService;
    private final SecurityService securityService;

    public ProfessorController(ProfessorService professorService, SecurityService securityService) {
        this.professorService = professorService;
        this.securityService = securityService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDTO save(@RequestBody ProfessorDTO professorDTO,@RequestHeader String authorization) {
        securityService.validateCredentials(authorization,Feature.REGISTER_PROFESSOR);
        return professorService.save(professorDTO);
    }
    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfessorDTO> getAllProfessors(){
        return professorService.getAllProfessors();
    }
    @PutMapping(consumes ="application/json",produces ="application/json" ,path = "{id}")
    public ProfessorDTO updateProf(@RequestBody ProfessorDTO profToUpdate, @PathVariable String id,@RequestHeader String authorization){
        securityService.validateCredentials(authorization,Feature.UPDATE_PROFESSOR);
        return professorService.updateProfessorById(profToUpdate,id);
    }

    @GetMapping(path = "{id}")
    public ProfessorDTO getProfessorById(@PathVariable String id,@RequestHeader String authorization){
        securityService.validateCredentials(authorization,Feature.GET_A_PROFESSOR);
        return professorService.getProfessorById(id);
    }
    @DeleteMapping(path = "{id}")
    public void deleteProfessor(@PathVariable String id,@RequestHeader String authorization){
        securityService.validateCredentials(authorization,Feature.DELETE_A_PROFESSOR);
        professorService.deleteProfessor(id);
    }
}