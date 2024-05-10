package com.example.demo.Controllers.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Controllers.BaseController;
import com.example.demo.Model.DTO.CourseDTO;
import com.example.demo.Model.Request.RequestCourse;
import com.example.demo.Services.CourseService;
import com.example.demo.Utils.HttpException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService _courService;

    BaseController<CourseDTO> _baseController = new BaseController<CourseDTO>();
    BaseController<List<CourseDTO>> _baseControllers = new BaseController<List<CourseDTO>>();

    @GetMapping()
    public ResponseEntity<?> Get() {
        try {
            return _baseControllers.Ok(_courService.GetAll());
        } catch (HttpException e) {
            return _baseControllers.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.Error(null, 500, e.getMessage());
        }
    }

    @PostMapping(value = "",  consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> Post( @ModelAttribute RequestCourse course) {
        try {
            return _baseController.Ok(_courService.Create(course));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> Put(@PathVariable int id, @RequestBody RequestCourse course) {
        try {
            return _baseController.Ok(_courService.Put(id, course));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> Get(@PathVariable int id) {
        try {
            return _baseController.Ok(_courService.GetById(id));
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

}
