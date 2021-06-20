package ex4;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expression = scan.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char currentElement = expression.charAt(i);
            if (currentElement == '(') {
                stack.push(i);
            } else if (currentElement == ')') {
                int starIndex = stack.pop();
                System.out.println(expression.substring(starIndex, i + 1));
            }
        }

    }
}
