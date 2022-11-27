package com.courserestapi.services;

import com.courserestapi.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {

    List<Course> getCourses();

    Course getCourse(int id);

    Course addCourse(Course course);

    Course updateCourse(Course course);

    Course deleteCourse(Integer id);
}
