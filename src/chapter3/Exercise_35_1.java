package chapter3;

public class Exercise_35_1 {
    public static void main(String[] args) {
        System.out.println(integrate(x -> 2 * x, 0, 1));
    }

// Your code complexity score is 8.19 (best for this step is 7.81).
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double result = 0;

        for (; a < b; a +=1e-7) result += f.applyAsDouble(a);
        return result * 1e-7;
    }
}

interface DoubleUnaryOperator{
    double applyAsDouble(Double f);
}