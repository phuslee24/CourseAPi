package com.example.demo.Repository;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Level;

import org.springframework.data.jpa.repository.JpaRepository;


@Component
public interface LevelRepo extends JpaRepository<Level, Integer> {
    
}
