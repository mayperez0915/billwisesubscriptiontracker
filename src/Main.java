import java.util.Scanner;
import presentation.Login;
import presentation.Mainmenu;
import service.LoginService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LoginService loginService = new LoginService();

        Login login = new Login(loginService, sc);

        if (login.execute()) {

            Mainmenu mainMenu = new Mainmenu();

            mainMenu.display(sc);
        }

        sc.close();
    }
}