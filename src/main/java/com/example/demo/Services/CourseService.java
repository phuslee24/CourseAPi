package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Course;
import com.example.demo.Model.DTO.CourseDTO;
import com.example.demo.Model.Map.Course.CourserMapping;
import com.example.demo.Model.Request.RequestCourse;
import com.example.demo.Repository.CourseRepo;
import com.example.demo.Services.IRepositoryServices.ICourseRepo;
import com.example.demo.Utils.HttpException;
import com.example.demo.Utils.Variable;

@Service
public class CourseService implements ICourseRepo {

    @Autowired
    CourseRepo _courseRepo;

    @Override
    public List<CourseDTO> GetAll() {
        List<Course> courses = _courseRepo.findAll();
        List<CourseDTO> courseDTOs = new ArrayList<>();
        if (courses.size() < 1) {
            throw new HttpException(404, Variable.DatabaseNull);
        }
        for (Course c : courses) {
            courseDTOs.add(CourserMapping.CourseDTO(c));
        }
        return courseDTOs;
    }

    @Override
    public CourseDTO Create(RequestCourse requestCourse) {
        Course course = CourserMapping.Course(requestCourse);
        _courseRepo.save(CourserMapping.Course(requestCourse));
        return (CourseDTO) CourserMapping.CourseDTO(course);
    }

    @Override
    public CourseDTO Put(int id, RequestCourse requestCourse) {
        Course getCourse = _courseRepo.findById(id).get();
        Course course = CourserMapping.CoursePut(requestCourse, getCourse);
        course.setId(id);
        _courseRepo.save(course);
        return (CourseDTO) CourserMapping.CourseDTO(course);
    }

    @Override
    public CourseDTO GetById(int id) {
        Course course = _courseRepo.myFindById(id);
        CourseDTO courseDTO = CourserMapping.CourseDTO(course);
        return courseDTO;
    }

}
