package com.example.demo.Controllers.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controllers.BaseController;
import com.example.demo.Model.DTO.LanguageDTO;
import com.example.demo.Services.LanguageService;
import com.example.demo.Utils.HttpException;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    LanguageService _langService;

    BaseController<LanguageDTO> _baseController = new BaseController<LanguageDTO>();
    BaseController<List<LanguageDTO>> _baseControllers = new BaseController<List<LanguageDTO>>();
    @GetMapping()
    public ResponseEntity<?> Get(){
        try {
            return _baseControllers.Ok(_langService.GetAll());
        }
        catch (HttpException e) {
            return _baseControllers.Error(null,e.StatusCode,e.message);
        }
        catch (Exception e) {
            return _baseControllers.Error(null,500,e.getMessage());
        }
    }

}
