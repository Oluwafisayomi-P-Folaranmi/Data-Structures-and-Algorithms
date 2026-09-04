public class Main {
    public static void main(String[] args) {
        int number = 7;
        System.out.println("The " + number + "th fibonacci number is: '" +
                fibonacci(number) + "'");
    }

    public static int fibonacci(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fibonacciOfNumberMinusOne = fibonacci(n - 1);
        int fibonacciOfNumberMinusTwo = fibonacci(n - 2);
        return fibonacciOfNumberMinusOne + fibonacciOfNumberMinusTwo;
    }
}
