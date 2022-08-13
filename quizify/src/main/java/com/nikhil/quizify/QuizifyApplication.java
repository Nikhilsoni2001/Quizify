package com.nikhil.quizify;

import com.nikhil.quizify.model.Role;
import com.nikhil.quizify.model.User;
import com.nikhil.quizify.model.UserRole;
import com.nikhil.quizify.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class QuizifyApplication {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(QuizifyApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        User user = new User();
//
//        user.setFirstName("Nikhil");
//        user.setLastName("Soni");
//        user.setUsername("nks");
//        user.setPassword(this.bCryptPasswordEncoder.encode("nksoni"));
//        user.setEmail("email");
//        user.setImageUrl("image");
//
//        Role role1 = new Role();
//        role1.setRoleId(1L);
//        role1.setRoleName("ADMIN");
//
//        Set<UserRole> userRoleSet = new HashSet<>();
//        UserRole userRole = new UserRole();
//
//        userRole.setRole(role1);
//        userRole.setUser(user);
//
//        userRoleSet.add(userRole);
//
//        User user1 = this.userService.createUser(user, userRoleSet);
//    }
}
