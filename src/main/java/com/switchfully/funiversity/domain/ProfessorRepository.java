package com.switchfully.funiversity.domain;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import static com.switchfully.funiversity.domain.Role.PRESIDENT;

@Repository
public class ProfessorRepository {
    private final ConcurrentHashMap<String, Professor> professorsDatabase;
    private static final Professor president = new Professor(
            "John",
            "Smith",
            "president@funiversity.com",
            "fun123",
            PRESIDENT
    );

    public ProfessorRepository() {
        this.professorsDatabase = new ConcurrentHashMap<>();
        professorsDatabase.put(president.getId(), president);
    }

    public Professor save(Professor professor) {
        professorsDatabase.put(professor.getId(), professor);
        return professor;
    }

    public Professor getProfessorById(String id) throws IllegalArgumentException {
        var foundProfessor = professorsDatabase.get(id);
        if (foundProfessor == null) {
            throw new IllegalArgumentException("No professor found with id " + id);
        }
        return foundProfessor;
    }

    public Collection<Professor> getAllProfessors() {
        return professorsDatabase.values();
    }

    public void deleteProfessor(String id) {
        professorsDatabase.remove(id);
    }

    public Professor updateProfessor(String id, Professor newProfData) {
        professorsDatabase.remove(id);
        professorsDatabase.put(id, newProfData);
        return getProfessorById(id);
    }

    public Professor getProfessorByEmail(String email) {
        var optionalProf = professorsDatabase.entrySet().stream().filter(entry -> entry.getValue().getEmail().equals(email)).findFirst();
        if (optionalProf.isPresent()) {
            return optionalProf.get().getValue();
        }
        throw new RuntimeException("professor not found");
    }
}
