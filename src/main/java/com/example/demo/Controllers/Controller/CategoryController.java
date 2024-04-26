package com.example.demo.Controllers.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controllers.BaseController;
import com.example.demo.Model.Level;
import com.example.demo.Model.DTO.CategoryDTO;
import com.example.demo.Services.CategoryService;
import com.example.demo.Utils.HttpException;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService _cateService;

    BaseController<Level> _baseController = new BaseController<Level>();
    BaseController<List<CategoryDTO>> _baseControllers = new BaseController<List<CategoryDTO>>();
    @GetMapping()
    public ResponseEntity<?> Get(){
        try {
            return _baseControllers.Ok(_cateService.GetAll());
        }
        catch (HttpException e) {
            return _baseControllers.Error(null,e.StatusCode,e.message);
        }
        catch (Exception e) {
            return _baseControllers.Error(null,500,e.getMessage());
        }
    }

}
