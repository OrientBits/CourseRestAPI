package com.courserestapi.controller;

        import com.courserestapi.entities.Course;
        import com.courserestapi.services.CourseService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") String id){

        try {
           this.courseService.deleteCourse(Long.parseLong(id));
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }

}
