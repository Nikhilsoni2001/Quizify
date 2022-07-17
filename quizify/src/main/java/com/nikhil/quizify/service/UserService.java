package com.nikhil.quizify.service;

import com.nikhil.quizify.model.User;
import com.nikhil.quizify.model.UserRole;

import java.util.Set;

public interface UserService {
     User createUser(User user, Set<UserRole> userRoles) throws Exception;
      User getUser(String username);
    void deleteUser(Long userId);

}
