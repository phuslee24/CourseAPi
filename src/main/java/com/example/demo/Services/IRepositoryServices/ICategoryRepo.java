package com.example.demo.Services.IRepositoryServices;

import java.util.List;

import com.example.demo.Model.DTO.CategoryDTO;

public interface ICategoryRepo {
    List<CategoryDTO> GetAll();
    
} 
