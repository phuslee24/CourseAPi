package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Category;
import com.example.demo.Model.DTO.CategoryDTO;
import com.example.demo.Repository.CategoryRepo;
import com.example.demo.Services.IRepositoryServices.ICategoryRepo;
import com.example.demo.Utils.HttpException;
import com.example.demo.Utils.Variable;

@Service
public class CategoryService implements ICategoryRepo {

    @Autowired
    CategoryRepo _cateRepo;

    @Override
    public List<CategoryDTO> GetAll() {
        List<Category> categories = _cateRepo.findAll();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        if (categories.size() < 1) {
            throw new HttpException(404, Variable.DatabaseNull);
        }
        for (Category c : categories) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(c.getId());
            if (c.getName()!=null) {
                categoryDTO.setName(c.getName());
            }
            categoryDTOs.add(categoryDTO);
        }
        return categoryDTOs;
    }

}
