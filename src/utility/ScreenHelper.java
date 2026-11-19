package utility;

import java.util.Scanner;

public class ScreenHelper {
    public static void pauseAndClear(Scanner sc) {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
