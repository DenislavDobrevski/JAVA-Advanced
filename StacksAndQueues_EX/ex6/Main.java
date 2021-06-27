package ex6;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);
            switch (element) {
                case '{':
                case '[':
                case '(':
                    stack.push(element);
                    break;
                case '}':
                case ']':
                case ')':
                    if (stack.isEmpty()) {
                        isBalanced = false;
                    } else {
                        char lastOpenBracket = stack.pop();
                        if (lastOpenBracket == '{' && element != '}') {
                            isBalanced = false;
                        } else if (lastOpenBracket == '[' && element != ']') {
                            isBalanced = false;
                        } else if (lastOpenBracket == '(' && element != ')') {
                            isBalanced = false;
                        }
                    }
                    break;
            }
            if (!isBalanced) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
