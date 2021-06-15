package ex2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s++");
        ArrayDeque<String> numbers = new ArrayDeque<>();

        for (int i = input.length - 1; i >= 0 ; i--) {
            numbers.push(input[i]);
        }

        while(numbers.size() > 1) {
            int firstNumber = Integer.parseInt(numbers.pop());
            String operator = numbers.pop();
            int secondNumber = Integer.parseInt(numbers.pop());

            int result = operator.equals("+")
                    ? firstNumber + secondNumber
                    : firstNumber - secondNumber;

            numbers.push(String.valueOf(result));
        }

        System.out.println(numbers.peek());

    }
}
