/*  Метод sqrt(), вычисляющий квадратный корень числа. В отличие от Math.sqrt(), это метод при передаче отрицательного
параметра должен бросать исключение java.lang.IllegalArgumentException с сообщением "Expected non-negative number,
got ?", где вместо вопросика будет подставлено фактически переданное в метод число.
 */
package chapter4;

public class Exercise_41_1 {
    public static void main(String[] args) {
        System.out.println(Exercise_41_1.sqrt(4));
        System.out.println(Exercise_41_1.sqrt(-4));
    }
    public static double sqrt(double x) {
        if (x < 0)
            throw new IllegalArgumentException("Expected non-negative number, got " + x);

        return Math.sqrt(x);
    }
}
