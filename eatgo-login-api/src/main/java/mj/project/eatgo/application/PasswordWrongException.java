package mj.project.eatgo.application;

public class PasswordWrongException extends RuntimeException{

    PasswordWrongException() {
        super("Password is wrong");
    }
}
