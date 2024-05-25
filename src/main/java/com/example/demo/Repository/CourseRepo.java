package com.example.demo.Repository;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Component
public interface CourseRepo extends JpaRepository<Course, Integer> {
      @Query("select u from Course u Where  id = ?1")  
      Course myFindById(int id);
      
      
      @Query("SELECT c.id, c.lesson, c.description, c.term,c.image ,c.language, c.created_at, c.updated_at FROM Course c")  
      // @Query(value = "Select c.id,c.lesson from Course as c join language as l on c.language_id = l.id ", nativeQuery = true)

      List<Course> getAllWithLangguage(); 

    
}
