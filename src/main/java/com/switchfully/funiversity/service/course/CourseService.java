package com.switchfully.funiversity.service.course;

import com.switchfully.funiversity.domain.course.CourseRepository;
import com.switchfully.funiversity.webapi.dto.course.CourseDTO;
import com.switchfully.funiversity.webapi.dto.course.CreateCourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;
    private CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public CourseDTO createCourse(CreateCourseDTO createCourseDTO) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toDomain(createCourseDTO)));
    }

    public List<CourseDTO> getAllCourses() {
        return courseMapper.toDTO(courseRepository.getAllCourses());
    }
}
