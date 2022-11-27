package com.courserestapi.services;

import com.courserestapi.entities.Course;

import java.util.List;


public interface CourseService {

    List<Course> getCourses();

    Course getCourse(long id);

    Course addCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(long id);
}
