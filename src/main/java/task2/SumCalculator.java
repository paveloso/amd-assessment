package task2;

/**
 * SumCalculator is a class that helps to calculate a sum of digits of a number
 */
public class SumCalculator {

    /**
     * method that helps to calculate a sum of digit within a number until there is a single digit left
     *
     * @param number integer number which will be split by digits and sum will be calculated
     * @return a sum of digits from a number
     */
    public static int digitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum > 9 ? digitSum(sum) : sum;
    }
}
