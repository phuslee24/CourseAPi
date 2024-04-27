package com.example.demo.Controllers.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controllers.BaseController;
import com.example.demo.Model.User;
import com.example.demo.Model.Request.RequestLogin;
import com.example.demo.Services.IRepositoryServices.IAuthenRepo;
import com.example.demo.Utils.HttpException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("")
public class LoginController {

    @Autowired
    IAuthenRepo _iauthenRepo;

    BaseController<String> _baseController = new BaseController<String>();
    BaseController<User> _baseControllerUser = new BaseController<User>();

    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody RequestLogin requestLogin) {
        try {
            String token = _iauthenRepo.Login(requestLogin);
            return _baseController.Ok(token);
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody RequestLogin requestLogin) {
        try {
            User user = _iauthenRepo.Register(requestLogin);
            return _baseControllerUser.Ok(user);
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }

}
