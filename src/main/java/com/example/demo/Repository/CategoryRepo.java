package com.example.demo.Repository;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Category;

import org.springframework.data.jpa.repository.JpaRepository;


@Component
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    
}
