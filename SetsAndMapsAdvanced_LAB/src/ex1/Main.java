package ex1;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        LinkedHashSet<String> parkedCars = new LinkedHashSet<>();

        while (!line.equals("END")) {
            String carNumber = line.split("\\s+")[1];

            if (line.contains("IN")) {
                parkedCars.add(carNumber);
            } else if (line.contains("OUT")) {
                parkedCars.remove(carNumber);
            }

            line = scan.nextLine();
        }

        if (!parkedCars.isEmpty()) {
            for (String car : parkedCars) {
                System.out.println(car);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
