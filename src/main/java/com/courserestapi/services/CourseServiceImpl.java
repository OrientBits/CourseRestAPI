package com.courserestapi.services;

import com.courserestapi.dao.CourseDao;
import com.courserestapi.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl(){
    }

    @Override
    public List<Course> getCourses() {
        return this.courseDao.findAll();
    }

    @Override
    public Course getCourse(long id) {
        return this.courseDao.findById(id).get() ;
    }

    @Override
    public Course addCourse(Course course) {
        this.courseDao.save(course);

        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        this.courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long id) {
        this.courseDao.deleteById(id);
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
