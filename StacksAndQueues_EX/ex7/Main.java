package ex7;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Long> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scan.nextLine());
        stack.push((long) 1);
        stack.push((long) 1);

        for (int i = 0; i < n - 1; i++) {
            long lastNumber = stack.pop();
            long nextNumber = lastNumber + stack.peek();
            stack.push(lastNumber);
            stack.push(nextNumber);
        }

        System.out.println(stack.peek());
    }
}
