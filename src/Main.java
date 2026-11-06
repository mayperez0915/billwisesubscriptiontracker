import java.util.Scanner;
import presentation.Login;
import presentation.MainMenu;
import service.LoginService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LoginService loginService = new LoginService();
        Login login = new Login(loginService, sc);

        if (login.execute()) {

            MainMenu mainMenu = new MainMenu(sc);
            mainMenu.display();

        }

        sc.close();
    }
}