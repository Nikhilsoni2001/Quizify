package com.nikhil.quizify.repository;

import com.nikhil.quizify.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
