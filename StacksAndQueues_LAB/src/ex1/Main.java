package ex1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();
        String input = scan.nextLine();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browser.size() > 1) {
                    browser.pop();
                    System.out.println(browser.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                browser.push(input);
                System.out.println(browser.peek());
            }

            input = scan.nextLine();
        }

    }
}
