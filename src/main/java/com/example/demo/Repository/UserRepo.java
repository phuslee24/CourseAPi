package com.example.demo.Repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.example.demo.Model.User;



@Component
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query("select u from User u Where u.user_name = ?1")  
    User findByUsername(String user_name); 

}