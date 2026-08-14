public class Main {
    public static void main(String[] args) {
        int number = 6;
        System.out.println("The " + number + "th fibonacci number is: '" +
                fib(number) + "'");
    }

    public static int fib(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int lastNumber = n;
        int numberPreviousOfLastNumber = n - 1;
        int numberPreviousToTheNumberPreviousOfLastNumber = n - 2;
        int fibonacciOfLastNumber = fib(numberPreviousOfLastNumber) + fib(numberPreviousToTheNumberPreviousOfLastNumber);
        return fibonacciOfLastNumber;
    }
}
