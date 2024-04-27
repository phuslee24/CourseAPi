package com.example.demo.Model.Map.Course;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Course;
import com.example.demo.Model.DTO.CourseDTO;

@Component
public class CourseMapper {
    public CourseDTO toCourseDTO(Course course) {
        ModelMapper mapper = new ModelMapper();
        CourseDTO result = mapper.map(course, CourseDTO.class);
        return result;
    }

    public List<CourseDTO> toCourseDTO(List<Course> course) {
        ModelMapper mapper = new ModelMapper();
        List<CourseDTO> getClass =new ArrayList<>();
        @SuppressWarnings("unchecked")
        List<CourseDTO> result = mapper.map(course, getClass.getClass());
        return result;
    }

    public Course toCourse(CourseDTO courseDTO) {
        ModelMapper mapper = new ModelMapper();
        Course result = mapper.map(courseDTO, Course.class);
        return result;
    }}
