package com.switchfully.funiversity.webapi;
import com.switchfully.funiversity.service.course.CourseService;
import com.switchfully.funiversity.webapi.dto.course.CourseDTO;
import com.switchfully.funiversity.webapi.dto.course.CreateCourseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    public CourseDTO CreateCourse(@RequestBody CreateCourseDTO createCourseDTO) {
        return courseService.createCourse(createCourseDTO);
    }
    @GetMapping(produces ="application/json")
    public List<CourseDTO> getAllCourses(){
        return courseService.getAllCourses();
    }
}
