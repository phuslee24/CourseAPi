package com.example.demo.SeedingData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Category;
import com.example.demo.Model.Course;
import com.example.demo.Model.Language;
import com.example.demo.Model.Level;
import com.example.demo.Model.User;
import com.example.demo.Repository.CategoryRepo;
import com.example.demo.Repository.CourseRepo;
import com.example.demo.Repository.LanguageRepo;
import com.example.demo.Repository.LevelRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.SeedingData.data.CategoryData;
import com.example.demo.SeedingData.data.CourseData;
import com.example.demo.SeedingData.data.LanguageData;
import com.example.demo.SeedingData.data.LevelData;
import com.example.demo.SeedingData.data.UserData;

@Component
public class Seeding implements CommandLineRunner {

    @Autowired
    LevelRepo _levelRepo;
    @Autowired
    LanguageRepo _languageRepo;
    @Autowired
    CategoryRepo _categoryRepo;
    @Autowired
    CourseRepo _courseRepo;
    @Autowired
    UserRepo _userRepo;

    @Override
    public void run(String... args) throws Exception {
        LoadLevelData();
        LoadLanguageData();
        LoadCategoryData();
        LoadCourseData();
        LoadUserData();
    }

    private void LoadLevelData() {
        if (_levelRepo.count() == 0) {

            List<Level> list = new LevelData().Data();
            for (Level l : list) {
                _levelRepo.save(l);
            }
        }
    }
    private void LoadLanguageData() {
        if (_languageRepo.count() == 0) {

            List<Language> list = new LanguageData().Data();
            for (Language l : list) {
                _languageRepo.save(l);
            }
        }
    }
    private void LoadCategoryData() {
        if (_categoryRepo.count() == 0) {

            List<Category> list = new CategoryData().Data();
            for (Category c : list) {
                _categoryRepo.save(c);
            }
        }
    }
    private void LoadCourseData() {
        if (_courseRepo.count() == 0) {

            List<Course> list = new CourseData().Data();
            for (Course c : list) {
                _courseRepo.save(c);
            }
        }
    }
    private void LoadUserData() {
        if (_userRepo.count() == 0) {

            List<User> list = new UserData().Data();
            for (User u : list) {
                _userRepo.save(u);
            }
        }
    }


}
