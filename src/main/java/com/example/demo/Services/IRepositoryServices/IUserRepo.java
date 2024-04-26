package com.example.demo.Services.IRepositoryServices;

import com.example.demo.Model.User;
import com.example.demo.Model.Request.RequestLogin;

public interface IUserRepo {
    String Login(RequestLogin requestLogin);
    User Register(RequestLogin requestLogin);

}
