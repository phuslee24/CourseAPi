package com.example.demo.Controllers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controllers.BaseController;
import com.example.demo.Model.Mail;
import com.example.demo.Services.IRepositoryServices.IMailRepo;
import com.example.demo.Utils.HttpException;

@RestController
@RequestMapping("")
public class MailController {

    @Autowired
    IMailRepo _iMailRepo;

    BaseController<String> _baseController = new BaseController<String>();

    @PostMapping("/send_mail")
    public ResponseEntity<?> SendMail(@RequestBody Mail mail) {
        try {
            String result = _iMailRepo.SendMail(mail);
            return _baseController.Ok(result);
        } catch (HttpException e) {
            return _baseController.Error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.Error(null, 500, e.getMessage());
        }
    }
}
