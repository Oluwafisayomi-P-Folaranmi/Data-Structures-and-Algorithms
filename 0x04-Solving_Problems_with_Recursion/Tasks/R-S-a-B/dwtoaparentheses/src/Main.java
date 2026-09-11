import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello.");
    }

    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {

            char operator = expression.charAt(i);

            if (operator == '+' || operator == '-' || operator == '*') {

                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);

                for (int leftResult : leftResults) {
                    for (int rightResult : rightResults) {

                        int result = 0;

                        if (operator == '+') {
                            result = leftResult + rightResult;
                        } else if (operator == '-') {
                            result = leftResult - rightResult;
                        } else {
                            result = leftResult * rightResult;
                        }

                        results.add(result);
                    }
                }
            }
        }

        // No operator means the expression is just a number.
        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }

        return results;
    }
}
