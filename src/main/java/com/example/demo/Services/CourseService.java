package com.example.demo.Services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Course;
import com.example.demo.Model.DTO.CourseDTO;
import com.example.demo.Model.Map.Course.CourseMapper;
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

    @Autowired
    CourseMapper _courseMap;

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
    public List<CourseDTO> GetAllWithLanguage() {
        List<Course> courses = _courseRepo.getAllWithLangguage();
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

        Path uploadPath = Paths.get("src/main/resources/Uploads/Images/");
        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectory(uploadPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        String fileCode = RandomStringUtils.randomAlphanumeric(8);
        String fileName ;
        try (InputStream inputStream = requestCourse.getFile().getInputStream()) {
            fileName = fileCode+"_"+requestCourse.getFile().getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new HttpException(500,e.getMessage());
        }
        Course course = CourserMapping.Course(requestCourse,fileName);

        _courseRepo.save(course);
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
