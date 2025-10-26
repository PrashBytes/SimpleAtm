import java.util.function.Function;

public class BonusCalculator {

    // Higher-order function: applies a bonus function to the salary
    public static double applyBonus(Function<Double, Double> func, double salary) {
        return func.apply(salary);
    }

    public static void main(String[] args) {
        double baseSalary = 50000;

        // Define bonus functions
        Function<Double, Double> festivalBonus = s -> s + 5000;     // flat bonus
        Function<Double, Double> performanceBonus = s -> s * 1.50; // 10% bonus

        // Apply bonuses using higher-order function
        double salaryWithFestival = applyBonus(festivalBonus, baseSalary);
        double salaryWithPerformance = applyBonus(performanceBonus, baseSalary);

        // Print results with consistent formatting (2 decimal places)
        System.out.printf("Base Salary: %.2f%n", baseSalary);
        System.out.printf("After Festival Bonus: %.2f%n", salaryWithFestival);
        System.out.printf("After Performance Bonus: %.2f%n", salaryWithPerformance);
    }
}