package ex3;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scan.nextLine().split("\\s++");
            switch (command[0]) {
                case "1": int newElement = Integer.parseInt(command[1]);
                stack.push(newElement);
                    break;
                case "2": stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }

    }
}
