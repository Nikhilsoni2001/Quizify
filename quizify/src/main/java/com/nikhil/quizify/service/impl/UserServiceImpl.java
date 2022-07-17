package com.nikhil.quizify.service.impl;

import com.nikhil.quizify.model.User;
import com.nikhil.quizify.model.UserRole;
import com.nikhil.quizify.repository.RoleRepository;
import com.nikhil.quizify.repository.UserRepository;
import com.nikhil.quizify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User already exists!");
            throw new Exception("User already exists!");
        } else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }
}
