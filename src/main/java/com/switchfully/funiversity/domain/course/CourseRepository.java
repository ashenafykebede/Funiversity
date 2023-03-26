package com.switchfully.funiversity.domain.course;

import com.switchfully.funiversity.webapi.dto.course.CourseDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CourseRepository {
    private List<Course> courses;

    public CourseRepository(List<Course> courses) {
        this.courses = courses;
        this.courses = new ArrayList<>();
    }
    public Course save(Course course){
        courses.add(course);
        return course;
    }

    public List<Course> getAllCourses() {
        return this.courses;
    }
}
