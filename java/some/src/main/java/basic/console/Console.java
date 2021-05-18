package basic.console;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input:");
        String s = scanner.nextLine();
        System.out.println("res:" + s);
    }
}
