package ex3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> binary = new ArrayDeque<>();
        int number = Integer.parseInt(scan.nextLine());

        if(number != 0) {
            while(number != 0) {
                if(number % 2 == 0) {
                    binary.push(0);
                } else {
                    binary.push(1);
                }
                number /= 2;
            }
        } else {
            System.out.println(0);
        }

        System.out.println(binary.toString().replaceAll("[\\[\\], ]", ""));
    }
}
