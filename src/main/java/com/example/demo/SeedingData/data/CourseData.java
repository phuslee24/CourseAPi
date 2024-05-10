package com.example.demo.SeedingData.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Category;
import com.example.demo.Model.Course;
import com.example.demo.Model.Language;
import com.example.demo.Model.Level;

@Component
public class CourseData {
    public List<Course> Data() {
        List<Course> data = new ArrayList<>();
        data.add(new Course(1, "Lesson 1", "Introduce my Course", null, null,
                new Category(1, null, null),
                new Language(2, null, null, null),
                new Level(1, null, null, null)));
        data.add(new Course(2, "Lesson 2", "Variable in java", null,null,
                new Category(1, null, null),
                new Language(2, null, null, null),
                new Level(1, null, null, null)));
        data.add(new Course(3, "Lesson 3", "List, ArrayList in java", null,null,
                new Category(1, null, null),
                new Language(2, null, null, null),
                new Level(3, null, null, null)));
        data.add(new Course(4, "Lesson 4", "Contructor in java", null,null,
                new Category(2, null, null),
                new Language(1, null, null, null),
                new Level(3, null, null, null)));
        data.add(new Course(5, "Lesson 1", "Introduce Course Restfull api with .NET", null,null,
                new Category(2, null, null),
                new Language(1, null, null, null),
                new Level(1, null, null, null)));
        data.add(new Course(6, "Lesson 2", "Code Connect database mysql in .NET", null,null,
                new Category(2, null, null),
                new Language(1, null, null, null),
                new Level(3, null, null, null)));
        return data;
    }
}
