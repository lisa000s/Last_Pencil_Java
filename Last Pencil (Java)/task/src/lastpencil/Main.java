package lastpencil;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pencils would you like to use:");
        String inputPencils = "";
        do {
            inputPencils = scanner.nextLine();
            try {
                Integer.parseInt(inputPencils);
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
                continue;
            }
            if (Integer.parseInt(inputPencils) <= 0) {
                System.out.println("The number of pencils should be positive");
            } else {
                break;
            }
        } while(true);

        int numberOfPencils = Integer.parseInt(inputPencils);
        System.out.println("Who will be the first (John, Jack):");
        String name = "";
        do {
            name = scanner.next();
            if (!Objects.equals(name, "John") && !Objects.equals(name, "Jack")) {
                System.out.println("Choose between 'John' and 'Jack'");
            } else {
                break;
            }
        } while(true);
        String whosTurn = name;
        for (int i = 0; i < numberOfPencils; i++) {
            System.out.print("|");
        }
        System.out.println();
        do {
            System.out.println(whosTurn + "'s turn!");
            do {
                if (whosTurn.equals("Jack")) {
                    inputPencils = "1";
                    for (int i = 4; i < 100; ) {
                        if (numberOfPencils == i) {
                            if (numberOfPencils >= 3) {
                                inputPencils = "3";
                                break;
                            }
                        }
                        i = i + 4;
                    }
                    for (int i = 3; i < 100; ) {
                        if (numberOfPencils == i) {
                            if (numberOfPencils >= 2) {
                                inputPencils = "2";
                                break;
                            }
                        }
                        i = i + 4;
                    }
                    for (int i = 2; i < 100; ) {
                        if (numberOfPencils == i) {
                            if (numberOfPencils >= 1) {
                                inputPencils = "1";
                                break;
                            }
                        }
                        i = i + 4;
                    }
                    System.out.println(inputPencils);
                } else {
                    inputPencils = scanner.next();
                }

                try {
                    Integer.parseInt(inputPencils);
                } catch (NumberFormatException e) {
                    System.out.println("Possible values: '1', '2' or '3'");
                    continue;
                }

                try {
                    if (!Objects.equals(inputPencils, "1") && !Objects.equals(inputPencils, "2") && !Objects.equals(inputPencils, "3")) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Possible values: '1', '2' or '3'");
                    continue;
                }
                try {
                    if (Integer.parseInt(inputPencils) > numberOfPencils) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Too many pencils were taken");
                    continue;
                }
                break;
            } while(true);
            whosTurn = Objects.equals(whosTurn, "John") ? "Jack": "John";
            if (numberOfPencils - Integer.parseInt(inputPencils) <= 0) {
                break;
            }
            numberOfPencils = numberOfPencils - Integer.parseInt(inputPencils);
            for (int i = 0; i < numberOfPencils; i++) {
                System.out.print("|");
            }
            System.out.println();
        } while (numberOfPencils >= 0);
        System.out.println(whosTurn + " won!");
    }
}
