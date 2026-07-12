public class ForecastingMain {

    /**
     * Recursive method to calculate future value.
     * Formula: Future Value = Present Value * (1 + Growth Rate)
     * * @param presentValue The starting amount of money
     * @param growthRate   The annual growth rate (e.g., 0.05 for 5%)
     * @param years        Number of years to look into the future
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base Case: If years is 0, the future value is just the current value
        if (years <= 0) {
            return presentValue;
        }
        
        // Recursive Case: Calculate the value for the previous year, then apply this year's growth
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialInvestment = 1000.0; // $1,000
        double annualRate = 0.05;          // 5% growth
        int forecastYears = 10;            // 10 years out

        System.out.println("--- Financial Forecasting Simulation ---");
        System.out.println("Initial Investment: $" + initialInvestment);
        System.out.println("Growth Rate: " + (annualRate * 100) + "% per year");
        System.out.println("Forecast Period: " + forecastYears + " years");

        // Run the recursive calculation
        double finalValue = calculateFutureValue(initialInvestment, annualRate, forecastYears);

        // Print results formatted to 2 decimal places
        System.out.printf("\nPredicted Future Value: $%.2f\n", finalValue);
    }
}