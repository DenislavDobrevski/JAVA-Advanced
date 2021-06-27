package ex5;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] robotsInput = scan.nextLine().split(";");
        LinkedHashMap<String, Integer> robots = robotsNameWorkingTime(robotsInput);
        int[] processTimes = new int[robotsInput.length];
        ArrayDeque<String> products = new ArrayDeque<>();

        String startingTime = scan.nextLine();
        long totalSeconds = timeInSeconds(startingTime);


        String product = scan.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scan.nextLine();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            boolean isAssigned = false;
            totalSeconds++;
            decreaseProcessTime(processTimes);

            int rWTIndex = -1;
            for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                rWTIndex++;
                if (processTimes[rWTIndex] == 0) {
                    isAssigned = true;
                    processTimes[rWTIndex] = robot.getValue();


                    System.out.printf("%s - %s %s%n",
                            robot.getKey(), currentProduct, getTime(totalSeconds));
                    break;
                }
            }

            if (!isAssigned) {
                products.offer(currentProduct);
            }
        }


    }

    private static LinkedHashMap<String, Integer> robotsNameWorkingTime(String[] robotsInput) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robot : robotsInput) {
            String name = robot.split("-")[0];
            int workingTime = Integer.parseInt(robot.split("-")[1]);
            if (!robots.containsKey(name)) {
                robots.put(name, workingTime);
            }
        }

        return robots;
    }

    private static int timeInSeconds(String startingTime) {
        int hoursInSec = Integer.parseInt(startingTime.split(":")[0]) * 3600;
        int minutesInSec = Integer.parseInt(startingTime.split(":")[1]) * 60;
        int seconds = Integer.parseInt(startingTime.split(":")[2]);
        return hoursInSec + minutesInSec + seconds;
    }

    private static void decreaseProcessTime(int[] processTimes) {
        for (int i = 0; i < processTimes.length; i++) {
            if (processTimes[i] > 0) {
                --processTimes[i];
            }
        }
    }

    private static String getTime(long currentTime) {
        long hours = (currentTime / 3600) % 24;
        long minutes = currentTime % 3600 / 60;
        long seconds = currentTime % 60;

        return String.format("[%02d:%02d:%02d]", hours, minutes, seconds);
    }
}
