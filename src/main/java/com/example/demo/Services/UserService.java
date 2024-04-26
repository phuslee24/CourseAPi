package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Model.Request.RequestLogin;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Services.IRepositoryServices.IUserRepo;
import com.example.demo.Utils.HttpException;
import com.example.demo.Utils.Regex;

@Service
public class UserService implements IUserRepo {

    @Autowired
    UserRepo _userRepo;

    @Autowired 
    Regex _regex;

    User user;
    BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();


    @Override
    public String Login(RequestLogin requestLogin) {
        User user = _userRepo.findByUsername(requestLogin.getUser_name());
        if(user==null){
            throw new HttpException(404,"User not in database!!");
        }
        boolean checkPassword = bCryptPasswordEncoder.matches( requestLogin.getPassword(),user.getPassword());
        if(checkPassword== false){
            throw new HttpException(400,"Password not correct!!");
        }
        //tao va tra ve token

        return "";
    }

    @Override
    public User Register(RequestLogin requestLogin) {

        boolean checkUsernameRequest =  _regex.validateUsername(requestLogin.getUser_name());
        if(!checkUsernameRequest){
            throw new HttpException(400,"User name not invalid");
        }
        user = _userRepo.findByUsername(requestLogin.getUser_name());
        if(user!=null){
            throw new HttpException(409,"user_name conflict in database");
        }
        user = new User();
        user.setUser_name(requestLogin.getUser_name());
        user.setPassword(bCryptPasswordEncoder.encode(requestLogin.getPassword()));
        _userRepo.save(user);
        return user;
    }

}
