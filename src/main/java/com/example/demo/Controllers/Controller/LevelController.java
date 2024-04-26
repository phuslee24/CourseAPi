package com.example.demo.Controllers.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controllers.BaseController;
import com.example.demo.Model.Level;
import com.example.demo.Model.DTO.LevelDTO;
import com.example.demo.Services.LevelService;
import com.example.demo.Utils.HttpException;

@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    LevelService _levelService;

    BaseController<Level> _baseController = new BaseController<Level>();
    BaseController<List<LevelDTO>> _baseControllers = new BaseController<List<LevelDTO>>();
    @GetMapping()
    public ResponseEntity<?> Get(){
        try {
            return _baseControllers.Ok(_levelService.GetAll());
        }
        catch (HttpException e) {
            return _baseControllers.Error(null,e.StatusCode,e.message);
        }
        catch (Exception e) {
            return _baseControllers.Error(null,500,e.getMessage());
        }
    }

}
