package ex5;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        String input = scan.nextLine();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (!printerQueue.isEmpty()) {
                    System.out.println("Canceled " + printerQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(input);
            }

            input = scan.nextLine();
        }

        for (String file : printerQueue) {
            System.out.println(file);
        }

    }
}
