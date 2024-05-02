package com.example.demo.SeedingData.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Category;

@Component
public class CategoryData {
    public List<Category> Data() {
        List<Category> data = new ArrayList<>();
        data.add(new Category(1, "FE", null));
        data.add(new Category(2, "BE", null));
        return data;
    }
}
