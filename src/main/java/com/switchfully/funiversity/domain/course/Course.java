package com.switchfully.funiversity.domain.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class Course {
    private UUID courseId;
    private String courseName;
    private int studyPoints;
    private UUID professorId;

    public Course(String name, int studyPoints, UUID professorId) {
        this.courseId = UUID.randomUUID();
        this.courseName = name;
        this.studyPoints = validateStudyPoint(studyPoints);
        this.professorId = professorId;
    }

    private static int validateStudyPoint(int studyPoints) {
        if (studyPoints<0 || studyPoints>6){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Study points should be between 1 and 6 inclusive");
        }
        return studyPoints;
    }

    public UUID getId() {
        return courseId;
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
