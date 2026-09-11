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

        // Highest sales per month
        // highestSalesPerMonth(sales);

        // Lowest sales per month
        // lowestSalesPerMonth(sales);

        // Total sales per month
        // totalSalesPerMonth(sales);

        // Average sales per month
        // averageSalesPerMonth(sales);

        // Highest-selling agent each month
        // highestSellingAgentEachMonth(sales);

        // Month with the highest total sales
        monthWithTheHighestSum(sales);
    }

    private static void highestSalesPerMonth(int[][] sales) {

        int NUM_MONTHS = 12;
        int NUM_AGENTS = 3;

        for (int month = 0; month < NUM_MONTHS; month++) {
            int highestSale = sales[month][0];

            for (int agent = 0; agent < NUM_AGENTS; agent++) {
                if (sales[month][agent] > highestSale) {
                    highestSale = sales[month][agent];
                }
            }

            System.out.println("The highest sale for month " +
                    (month + 1) + " is -> " + highestSale);
        }
    }

    private static void lowestSalesPerMonth(int[][] sales) {

        int NUM_MONTHS = 12;
        int NUM_AGENTS = 3;

        for (int month = 0; month < NUM_MONTHS; month++) {
            int lowestSale = sales[month][0];

            for (int agent = 0; agent < NUM_AGENTS; agent++) {
                if (sales[month][agent] < lowestSale) {
                    lowestSale = sales[month][agent];
                }
            }

            System.out.println("The highest sale for month " +
                    (month + 1) + " is -> " + lowestSale);
        }
    }

    private static void totalSalesPerMonth(int[][] sales) {

        int NUM_AGENTS = 3;
        int NUM_MONTHS = 12;

        int sum = 0;
        for (int month = 0; month < NUM_MONTHS; month++) {
            for (int agent = 0; agent < NUM_AGENTS; agent++) {
                sum += sales[month][agent];
            }

            System.out.println("Sum for month " + (month + 1) + " is -> " + sum);
            sum = 0;
        }
    }

    private static void averageSalesPerMonth(int[][] sales) {

        int NUM_AGENTS = 3;
        int NUM_MONTHS = 12;

        int sum = 0;
        float average = 0;
        for (int month = 0; month < NUM_MONTHS; month++) {
            for (int agent = 0; agent < NUM_AGENTS; agent++) {
                sum += sales[month][agent];
            }
            average = (float) sum / NUM_AGENTS;

            System.out.println("Average for month " + (month + 1) + " is -> " + average);
            sum = 0;
        }
    }

    private static void highestSellingAgentEachMonth(int[][] sales) {

        int NUM_AGENTS = 3;
        int NUM_MONTHS = 12;

        int highestSale = sales[0][0];
        int highestSaleIndex = 0;

        // Just to let us know how many agents are in our data
        System.out.println("There are 'three' agents:");
        for (int month = 0; month < NUM_MONTHS; month++) {

            for (int agent = 0; agent < NUM_AGENTS; agent++) {
                if (sales[month][agent] > highestSale) {
                    highestSaleIndex = agent;
                }
            }
            System.out.println("Agent '" + (highestSaleIndex + 1) +
                    "' has the highest sale in the month '" +
                    (month + 1) + "'");
        }
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
