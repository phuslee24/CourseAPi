package com.example.demo.Model.Map.Course;

import com.example.demo.Model.Category;
import com.example.demo.Model.Course;
import com.example.demo.Model.Language;
import com.example.demo.Model.Level;
import com.example.demo.Model.DTO.CategoryDTO;
import com.example.demo.Model.DTO.CourseDTO;
import com.example.demo.Model.DTO.LanguageDTO;
import com.example.demo.Model.DTO.LevelDTO;
import com.example.demo.Model.Request.RequestCourse;

public class CourserMapping {
    public static CourseDTO CourseDTO(Course c) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(c.getId());
        courseDTO.setLesson(c.getLesson());
        courseDTO.setDescription(c.getDescription());
        courseDTO.setTerm(c.getTerm());
        courseDTO.setCategory(
                new CategoryDTO(c.getCategory().getId(), c.getCategory().getName()));
        courseDTO.setLanguage(
                new LanguageDTO(c.getLanguage().getId(), c.getLanguage().getName(), c.getLanguage().getDescription()));
        courseDTO.setLevel(
                new LevelDTO(c.getLevel().getId(), c.getLevel().getName(), c.getLevel().getSign()));
        return courseDTO;
    }
    public static Course Course(RequestCourse c) {
        Course course = new Course();
        course.setLesson(c.getLesson());
        course.setDescription(c.getDescription());
        course.setTerm(c.getTerm());
        course.setCategory(new Category(c.getCategory_id(), null, null));
        course.setLevel(new Level(c.getLevel_id(), null, null, null));
        course.setLanguage(new Language(c.getLanguage_id(), null, null, null));
        return course;
    }
    public static Course CoursePut(RequestCourse rc, Course c) {
        if (rc.getLesson() != null) {
            c.setLesson(rc.getLesson());
        }
        if (rc.getDescription() != null) {
            c.setDescription(rc.getDescription());
        }
        if (rc.getTerm() != null) {
            c.setTerm(rc.getTerm());
        }
        if (rc.getCategory_id() != 0) {
            c.setCategory(new Category(rc.getCategory_id(), null, null));
        }
        if (rc.getCategory_id() != 0) {
            c.setCategory(new Category(rc.getCategory_id(), null, null));
        }
        if (rc.getLevel_id() != 0) {
            c.setLevel(new Level(rc.getLevel_id(), null, null, null));
        }
        if (rc.getLanguage_id() != 0) {
            c.setLanguage(new Language(rc.getLanguage_id(), null, null, null));
        }
        return c;
    }
}
