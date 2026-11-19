package service;


public class LoginService {
    private final String username = "User";
    private final String password = "user123";

    public boolean authenticate(String enterUsername, String enterPassword){

        return username.equals(enterUsername) &&
        password.equals(enterPassword);
    }
}