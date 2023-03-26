package com.switchfully.funiversity.webapi.dto.course;

import java.util.UUID;

public class CreateCourseDTO {
    private final String courseName;
    private final int studyPoints;
    private final UUID professorId;

    public CreateCourseDTO(String name, int studyPoints, UUID professorId) {
        this.courseName = name;
        this.studyPoints = studyPoints;
        this.professorId = professorId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public UUID getProfessorId() {
        return professorId;
    }
}
