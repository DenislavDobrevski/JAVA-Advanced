package ex6;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s++");
        int number = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, input);

        while (kids.size() > 1) {
            String currentKid = "";
            for (int i = 0; i < number; i++) {
                currentKid = kids.poll();
                kids.offer(currentKid);
            }
            System.out.printf("Removed %s%n", currentKid);
            kids.remove(currentKid); // i=1... kids.poll();
        }

        System.out.printf("Last is %s", kids.peek());

    }
}