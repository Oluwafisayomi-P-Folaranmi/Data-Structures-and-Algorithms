public class Main {
    public static void main(String[] args) {
        System.out.println("Hello.");
        int[][] sales = {
                {1856, 5865, 23},       // Month 1
                {498, 5456, 55},        // Month 2
                {30924, 3983, 67},      // Month 3
                {87478, 6464, 99},      // Month 4
                {328, 9957, 265},       // Month 5
                {2653, 4785, 376},      // Month 6
                {387, 3875, 232},       // Month 7
                {3754, 3838, 223},      // Month 8
                {387587, 4959, 4546},   // Month 9
                {2873, 1122, 564},      // Month 10
                {276, 7766, 4544},      // Month 11
                {32, 2534, 3434}        // Month 12
        };

        // ---------------------------------- Know the --------------------------------------------------
        // ---------------------------------- Total sales for the year ----------------------------------
        // System.out.println("The total sales for the year is '" + totalSalesForTheYear(sales) + "'.");

        // ---------------------------------- Know the --------------------------------------------------
        // ---------------------------------- Average monthly sales -------------------------------------
        // double[] resultOfAverage = averageMonthlySales(sales);
        // for (double average : resultOfAverage) {
            // System.out.println(average);
        // }

        // ---------------------------------- Know the --------------------------------------------------
        // ---------------------------------- Highest monthly sales -------------------------------------
        // int[] resultOfHighest = highestMonthlySales(sales);
        // for (int average : resultOfHighest) {
           // System.out.println(average);
        // }

        // ---------------------------------- Know the --------------------------------------------------
        // ---------------------------------- Lowest monthly sales --------------------------------------
        int[] resultOfLowest = lowestMonthlySales(sales);
        for (int average : resultOfLowest) {
            System.out.println(average);
        }
    }

    // Total sales for the year: totalSalesForTheYear
    private static double totalSalesForTheYear(int[][] sales) {
        final int NUM_MONTHS = sales.length;
        final int NUM_AGENTS = 3;

        int total = 0;
        for (int month = 0; month < NUM_MONTHS; month++) {
            for (int agent = 0; agent < NUM_AGENTS; agent++) {
                int monthSales = sales[month][agent];
                total += monthSales;
            }
        }
        return total;
    }
    // Average monthly sales: averageMonthlySales
    private static double[] averageMonthlySales(int[][] sales) {
        final int NUM_MONTHS = sales.length;
        final int NUM_AGENTS = 3;

        double[] result = new double[12];

        for (int month = 0; month < NUM_MONTHS; month++) {
            int sum = 0;
            for (int agent = 0; agent < NUM_AGENTS; agent++) {
                sum += sales[month][agent];
            }
            double average = (double) sum /NUM_AGENTS;
            result[month] = average;
        }

        return result;
    }

    // Highest monthly sales: highestMonthlySales
    private static int[] highestMonthlySales(int[][] sales) {
        final int NUM_MONTHS = sales.length;
        final int NUM_AGENTS = 3;

        int[] result = new int[12];

        for (int month = 0; month < NUM_MONTHS; month++) {
            int highest = sales[month][0];
            for (int agent = 0; agent < NUM_AGENTS; agent++) {
                int current = sales[month][agent];
                if (current > highest) {
                    highest = current;
                }
            }
            result[month] = highest;
        }

        return result;
    }

    // Lowest monthly sales: lowestMonthlySales
    private static int[] lowestMonthlySales(int[][] sales) {
        final int NUM_MONTHS = sales.length;
        final int NUM_AGENTS = 3;

        int[] result = new int[12];

        for (int month = 0; month < NUM_MONTHS; month++) {
            int lowest = sales[month][0];
            for (int agent = 0; agent < NUM_AGENTS; agent++) {
                int current = sales[month][agent];
                if (current < lowest) {
                    lowest = current;
                }
            }
            result[month] = lowest;
        }

        return result;
    }
}
