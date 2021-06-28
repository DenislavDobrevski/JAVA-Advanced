package ex8;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scan.nextLine());

        ArrayDeque<Character> elements = new ArrayDeque<>();
        ArrayDeque<String> undos = new ArrayDeque<>();
        boolean checkLastCommand = true;

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scan.nextLine().split("\\s++");

            switch (command[0]) {
                case "1":
                    checkLastCommand = false;
                    String text = command[1];
                    for (int j = 0; j < text.length(); j++) {
                        elements.push(text.charAt(j));
                    }
                    undos.push(backupIfUndo(elements));
                    break;
                case "2":
                    checkLastCommand = false;
                    int eraseCount = Integer.parseInt(command[1]);
                    for (int j = 0; j < eraseCount; j++) {
                        elements.pop();
                    }
                    undos.push(backupIfUndo(elements));
                    break;
                case "3":
                    checkLastCommand = false;
                    int index = Integer.parseInt(command[1]);
                    ArrayDeque<Character> tempStack = new ArrayDeque<>();

                    while (!elements.isEmpty()) {
                        tempStack.push(elements.pop());
                    }
                    int count = 1;

                    while (!tempStack.isEmpty()) {
                        if (count == index) {
                            System.out.println(tempStack.peek());
                        }
                        elements.push(tempStack.pop());
                        count++;
                    }
                    break;
                case "4":
                    elements.clear();
                    if(!checkLastCommand) {
                        undos.pop();
                    }
                    if(!undos.isEmpty()) {
                        String lastCommand = undos.pop();
                        for (int j = 0; j < lastCommand.length(); j++) {
                            elements.push(lastCommand.charAt(j));
                        }
                    }
                    checkLastCommand = true;

                    break;
            }
        }

    }

    private static String backupIfUndo(ArrayDeque<Character> elements) {
        StringBuilder tempSB = new StringBuilder();
        while (!elements.isEmpty()) {
            tempSB.append(elements.pop());
        }
        tempSB.reverse();
        for (int i = 0; i < tempSB.length(); i++) {
            elements.push(tempSB.charAt(i));
        }
        return tempSB.toString();

    }
}
