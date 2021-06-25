package ex2;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int elementsToPush = scan.nextInt();
        int elementsToPop = scan.nextInt();
        int elementToCheck = scan.nextInt();

        for (int i = 0; i < elementsToPush; i++) {
            numbers.push(scan.nextInt());
        }

        for (int i = 0; i < elementsToPop; i++) {
            numbers.pop();
        }

        if(!numbers.isEmpty()) {
            if (numbers.contains(elementToCheck)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(numbers));
            }
        } else {
            System.out.println("0");
        }
    }
}
