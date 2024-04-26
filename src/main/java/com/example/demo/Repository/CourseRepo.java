package com.example.demo.Repository;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Component
public interface CourseRepo extends JpaRepository<Course, Integer> {
      @Query("select u from Course u Where  id = ?1")  
      Course myFindById(int id); 
    
}
