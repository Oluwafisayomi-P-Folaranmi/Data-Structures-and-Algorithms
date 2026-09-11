public class Main {
    public static void main(String[] args) {

        // sales by month
        int[][] sales = {
                {1856, 5865, 23},
                {498,  5456, 55},
                {30924, 3983, 67},
                {87478, 6464, 99},
                {328,   9957, 265},
                {2653,  4785, 376},
                {387,   3875, 232},
                {3754,  3838, 223},
                {387587, 4959, 4546},
                {2873,  1122, 564},
                {276,   7766, 4544},
                {32,    2534, 3434}
        };

        // Month with the highest total sales
        monthWithTheHighestSum(sales);
    }

    private static void monthWithTheHighestSum(int[][] sales) {

        int NUM_AGENTS = 3;
        int NUM_MONTHS = 12;

        int currentSum = 0;
        int highestSum = 0;
        int indexOfTheMonthWithTheHighestSum = 0;

        for (int month = 0; month < NUM_MONTHS; month++) {

            for (int agent = 0; agent < NUM_AGENTS; agent++) {

                currentSum += sales[month][agent];

            }

            if (currentSum > highestSum) {
                highestSum = currentSum;
                indexOfTheMonthWithTheHighestSum = month;
            }

            currentSum = 0;
        }

        System.out.println("Month '" + (indexOfTheMonthWithTheHighestSum + 1) +
                "' has the highest total sales.");
    }
}
