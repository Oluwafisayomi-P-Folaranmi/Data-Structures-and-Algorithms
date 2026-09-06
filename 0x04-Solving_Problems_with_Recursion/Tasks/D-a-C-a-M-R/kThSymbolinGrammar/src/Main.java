public class Main {
    public static void main(String[] args) {

    }

    public static int kthGrammar(int n, int k) {

        // Base case
        if (n == 1) {
            return 0;
        }

        int half = 1 << (n - 2);

        // k is in the first half
        if (k <= half) {
            return kthGrammar(n - 1, k);
        }

        // k is in the second half
        return 1 - kthGrammar(n - 1, k - half);
    }
}
