package com.courserestapi.controller;

        import com.courserestapi.entities.Course;
        import com.courserestapi.services.CourseService;
        import com.courserestapi.services.CourseServiceImpl;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
public class MyController {


    @Autowired
    private CourseService courseService;


    @GetMapping("/courses")
    public List<Course> test(){
        return this.courseService.getCourses();
    }


    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable("id") Integer id){

        return  this.courseService.getCourse(id);
    }


    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        System.out.println("Hello post mapping");
        return this.courseService.addCourse(course);
    };

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        System.out.println("Hello put mapping");
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public Course deleteCourse(@PathVariable("id") Integer id){

        return this.courseService.deleteCourse(id);
    }

}
