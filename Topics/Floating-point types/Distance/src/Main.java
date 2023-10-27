import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double distance = scanner.nextInt();
        double hours = scanner.nextInt();
        double averageSpeed = distance / hours;
        System.out.print(averageSpeed);
    }
}