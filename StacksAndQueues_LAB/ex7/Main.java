package ex7;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s++");
        int n = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, input);

        int cycle = 1;

        while(kids.size() > 1){
            for (int i = 1; i < n; i++) {
                kids.offer(kids.poll());
            }
            if(isPrime(cycle)) {
                System.out.println("Prime " + kids.peek());
            } else {
                System.out.println("Removed " + kids.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + kids.peek());

    }

    private static boolean isPrime(int cycle) {
        if(cycle == 1) {
            return false;
        }
        for (int i = 2; i <= cycle / 2 ; i++) {
            if(cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}
