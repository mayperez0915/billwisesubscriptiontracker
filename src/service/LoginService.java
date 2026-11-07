package service;


public class LoginService {
    private final String username = "admin";
    private final String password = "admin123";

    public boolean authenticate(String enterUsername, String enterPassword){

        return username.equals(enterUsername) &&
        password.equals(enterPassword);
    }
}