package service;
import model.User;

public class LoginService {
    private User user;

    public LoginService (){
        user = new User ("admin", "admin123");
    }
    public boolean authenticate (String username, String password){
        if (user.getUsername().equals(username)
        && user.getPassword().equals(password)){
            
            return true;
        }
        return false;
    }
}