package com.switchfully.funiversity.webapi.dto.course;

import java.util.UUID;

public class CourseDTO {
    private final UUID courseId;
    private final String courseName;
    private final int studyPoints;
    private final UUID professorId;

    public CourseDTO(UUID courseId,String name, int studyPoints, UUID professorId) {
        this.courseId = courseId;
        this.courseName = name;
        this.studyPoints = studyPoints;
        this.professorId = professorId;
    }

    public UUID getCourseId() {
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
