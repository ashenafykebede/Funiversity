package com.switchfully.funiversity.domain;

import com.switchfully.funiversity.domain.professor.Professor;
import com.switchfully.funiversity.domain.professor.ProfessorRepository;
import com.switchfully.funiversity.domain.professor.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class ProfessorRepositoryTest {
    private static final Professor prof_koen = new Professor("Koen", "Van Ramsi","koen@funiversity.com","fun123");
    private static final Professor prof_janssen = new Professor("Eric","Janssen","Janssen@funiversity.com","fun123");
   private static final ProfessorRepository professorRepository = new ProfessorRepository();

    @Test
    void givenAProfessor_whenSaving_thenTheSavedProfessorAndTheProfessorToSaveShouldBeEqual() {
        //Given a professor

        //When
        Professor saved_professor = professorRepository.save(prof_koen);

        //Then
        Assertions.assertEquals(saved_professor, prof_koen);

    }

    @Test
    void givenANumberOfProfessorsInTheDatabase_whenSearchingAProfessorById_shouldRetrieveTheExactCrosspondingProfessor() {
        //Given professors

        //when
        Professor professorY = new Professor("Funny","Professor","fun@funiversity.com","fun123");
        professorRepository.save(prof_koen);
        professorRepository.save(prof_janssen);
        professorRepository.save(professorY);

        //Then

        Assertions.assertEquals(professorY,professorRepository.getProfessorById(professorY.getId()));
    }

    @Test
    void givenARandomId_whenSearchingAProfessorById_thenThrowsAnException() {
        //Given
        String unknownRandomId= UUID.randomUUID().toString();
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            //When
            professorRepository.getProfessorById(unknownRandomId);
        });
        //Then
        Assertions.assertEquals("No professor found with id " +unknownRandomId,exception.getMessage());
    }
}