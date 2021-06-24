package ex8;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> browserBack = new ArrayDeque<>();
        ArrayDeque<String> browserForward = new ArrayDeque<>();
        String input = scan.nextLine();

        while (!input.equals("Home")) {

            switch (input) {
                case "back":
                    if (browserBack.size() > 1) {
                        browserForward.addFirst(browserBack.pop());
                        System.out.println(browserBack.peek());
                    } else {
                        System.out.println("no previous URLs");
                    }
                    break;
                case "forward":
                    if (browserForward.size() > 0) {
                        browserBack.push(browserForward.poll());
                        System.out.println(browserBack.peek());
                    } else {
                        System.out.println("no next URLs");
                    }
                    break;
                default:
                    browserBack.push(input);
                    System.out.println(browserBack.peek());
                    browserForward.clear();
                    break;
            }

            input = scan.nextLine();
        }

    }
}

