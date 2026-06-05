package Day5;

public class Pow {
    public double myPow(double x, int n) {

        long power = n; // use long to handle Integer.MIN_VALUE

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double ans = 1.0;

        while (power > 0) {

            // if power is odd
            if (power % 2 == 1) {
                ans = ans * x;
            }

            x = x * x;
            power = power / 2;
        }

        return ans;
    }
}
