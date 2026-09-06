public class Main {
    public static void main(String[] args) {

    }

    public static char findKthBit(int n, int k) {

        // Base case
        if (n == 1) {
            return '0';
        }

        // Middle position
        int middle = 1 << (n - 1);

        // Case 1: k is in the left half
        if (k < middle) {
            return findKthBit(n - 1, k);
        }

        // Case 2: k is the middle position
        if (k == middle) {
            return '1';
        }

        // Case 3: k is in the right half
        char bit = findKthBit(n - 1, (1 << n) - k);

        // Invert the bit
        return bit == '0' ? '1' : '0';
    }
}
