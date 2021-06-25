package ex4;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int N = scan.nextInt();
        int S = scan.nextInt();
        int X = scan.nextInt();

        for (int i = 0; i < N; i++) {
            numbers.offer(scan.nextInt());
        }

        for (int i = 0; i < S; i++) {
            numbers.poll();
        }

        if (!numbers.isEmpty()) {
            if (numbers.contains(X)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(numbers));
            }
        } else {
            System.out.println("0");
        }
    }
}


