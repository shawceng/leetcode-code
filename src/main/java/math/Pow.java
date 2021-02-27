package math;

public class Pow {
    public double myPow(double x, int n) {
        if (n < 0) return 1.0 / power(x, -n);
        return power(x, n);
    }

    private double power(double x, int n) {
        if (n == 0) return 1;
        double v = power(x, n / 2);
        if (x % 2 == 0) return v * v;
        else return x * v * v;
    }
}
