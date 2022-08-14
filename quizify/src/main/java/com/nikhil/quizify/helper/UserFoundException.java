package com.nikhil.quizify.helper;

public class UserFoundException extends Exception {
    public UserFoundException() {
        super("User already exists!!");
    }

    public UserFoundException(String msg) {
        super(msg);
    }
}
