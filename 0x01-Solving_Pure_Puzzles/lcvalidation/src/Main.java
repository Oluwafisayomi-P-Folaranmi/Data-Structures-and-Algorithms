import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a single digit number, 0-9: ");
        char digit = scanner.next().charAt(0);
        int input = (int) digit;

        System.out.print("You entered '" + input + "'");
    }
}
