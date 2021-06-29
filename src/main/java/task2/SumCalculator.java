package task2;

public class SumCalculator {

    public static int digitSum(int number) {
        if (number < 10) {
            return number;
        }

        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number = number / 10;
        }

        return sum > 9 ? digitSum(sum) : sum;
    }
}
