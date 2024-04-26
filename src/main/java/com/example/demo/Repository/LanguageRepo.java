package com.example.demo.Repository;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Language;

import org.springframework.data.jpa.repository.JpaRepository;


@Component
public interface LanguageRepo extends JpaRepository<Language, Integer> {
    
}
