package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Enums.Role;
import com.example.demo.Model.User;
import com.example.demo.Model.Request.RequestLogin;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Services.IRepositoryServices.IAuthenRepo;
import com.example.demo.Services.IRepositoryServices.IJwtRepo;
import com.example.demo.Utils.Regex;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenRepo {

    @Autowired
    UserRepo _userRepo;

    @Autowired
    Regex _regex;

    @Autowired
    AuthenticationManager _authenticationManager;

    @Autowired
    IJwtRepo _jwtservice;

    @Autowired
    PasswordEncoder _passwordEncoder;




    @Override
    public String Login(RequestLogin requestLogin) {
        _authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestLogin.getUser_name(),
                requestLogin.getPassword()));

        var user = _userRepo.findByUsername(requestLogin.getUser_name());
        var token = _jwtservice.generateToken(user);
        // var refreshToken = _jwtservice.generateRefreshToken(new HashMap<>(), user);

        // JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();

        // jwtAuthenticationResponse.setToken(jwt);
        // jwtAuthenticationResponse.setRefreshToken(refreshToken);

        return token;
    }

    @Override
    public User Register(RequestLogin requestLogin) {

        User user = new User();
        user.setUser_name(requestLogin.getUser_name());
        user.setRole(Role.USER);
        user.setPassword(_passwordEncoder.encode(requestLogin.getPassword()));
        return _userRepo.save(user);
    }

 

}
