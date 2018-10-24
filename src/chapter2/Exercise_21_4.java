package chapter2;

public class Exercise_21_4 {
    public static void main(String[] args) {
        double a = 2;
        double b = 3;
        double c = 3.01;
        System.out.println(Math.abs((a + b) - c) < 0.0001d);
    }
}
