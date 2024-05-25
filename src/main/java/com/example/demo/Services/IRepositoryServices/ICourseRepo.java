package com.example.demo.Services.IRepositoryServices;

import java.util.List;

import com.example.demo.Model.DTO.CourseDTO;
import com.example.demo.Model.Request.RequestCourse;

public interface ICourseRepo {
    List<CourseDTO> GetAll();
    List<CourseDTO> GetAllWithLanguage();
    CourseDTO Create(RequestCourse requestCourse);
    CourseDTO Put(int id,RequestCourse requestCourse);
    CourseDTO GetById(int id);

} 
