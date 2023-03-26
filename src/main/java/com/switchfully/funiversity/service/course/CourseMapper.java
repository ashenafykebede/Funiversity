package com.switchfully.funiversity.service.course;

import com.switchfully.funiversity.domain.course.Course;
import com.switchfully.funiversity.webapi.dto.course.CourseDTO;
import com.switchfully.funiversity.webapi.dto.course.CreateCourseDTO;
import com.switchfully.funiversity.webapi.dto.course.UpdateCourseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course){
        return new CourseDTO(
                course.getId(),
                course.getCourseName(),
                course.getStudyPoints(),
                course.getProfessorId()
        );
    }
    public List<CourseDTO> toDTO(List<Course> courses){
        return courses.stream().map(this::toDTO).collect(Collectors.toList());
    }
    public Course toDomain(CreateCourseDTO createCourseDTO){
        return new Course(
                createCourseDTO.getCourseName(),
                createCourseDTO.getStudyPoints(),
                createCourseDTO.getProfessorId()
        );
    }
    public Course toDomain(UpdateCourseDTO updateCourseDTO){
        return new Course(
                updateCourseDTO.getCourseName(),
                updateCourseDTO.getStudyPoints(),
                updateCourseDTO.getProfessorId()
        );
    }
}
