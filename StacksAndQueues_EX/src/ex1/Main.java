package ex1;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s++");
        ArrayDeque<String> numbers = new ArrayDeque<>();

        for (String number : input) {
            numbers.push(number);
        }

        while (!numbers.isEmpty()) {
            System.out.printf("%s ", numbers.pop());
        }
    }
}
