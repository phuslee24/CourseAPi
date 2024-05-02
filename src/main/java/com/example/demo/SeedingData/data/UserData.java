package com.example.demo.SeedingData.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Enums.Role;
import com.example.demo.Model.User;

@Component
public class UserData {
    public List<User> Data() {
        List<User> data = new ArrayList<>();
        data.add(new User(0, "admin", "0367977***", "admin", Role.ADMIN));
        data.add(new User(0, "manager", "0927794***", "manager", Role.MANAGER));
        data.add(new User(0, "user", "01627303***", "user", Role.USER));

        return data;
    }
}
