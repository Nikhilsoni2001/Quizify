package com.nikhil.quizify.model;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class Authority implements GrantedAuthority {

    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
