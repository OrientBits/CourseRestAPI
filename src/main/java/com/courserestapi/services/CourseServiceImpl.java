package com.courserestapi.services;

import com.courserestapi.entities.Course;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {


    List<Course> courseList = new ArrayList<>();

    public CourseServiceImpl(){
        courseList.add(new Course(145,"Java Core Course","This course contains basics of java"));
        courseList.add(new Course(146,"Spring boot Course","Creating rest api using spring boot"));

    }


    @Override
    public List<Course> getCourses() {

        return courseList;
    }

    @Override
    public Course getCourse(int id) {
        return courseList.stream().filter(c -> c.getId() == id).findAny().get();
    }

    @Override
    public Course addCourse(Course course) {
        courseList.add(course);
        System.out.println("Courses added: "+course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        courseList = courseList.stream().map(c -> update(c,course)).collect(Collectors.toList());
        return course;
    }

    @Override
    public Course deleteCourse(Integer id) {

        Course course = courseList.stream().filter(c -> c.getId() == id).findAny().get();
        courseList.remove(course);

        return course;
    }

    private Course update(Course c,Course newCourse) {
        if (c.getId() == newCourse.getId()){

            c.setTitle(newCourse.getTitle());
            c.setDescription(newCourse.getDescription());
            return c;
        }else{
            return c;
        }
    }


}
