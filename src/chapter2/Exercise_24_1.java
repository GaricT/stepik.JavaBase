package chapter2;
/**
 * Вычисление факториала
 */
import java.math.BigInteger;
import java.util.Timer;


public class Exercise_24_1 {
    public static void main(String[] args) {
        BigInteger var1;
        BigInteger var2;
        int endVal = 12000;
        long start = System.currentTimeMillis();
        var1 = FactTree(endVal);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        var2 = FactEasy(endVal);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(var1.subtract(var2));
    }

    public static BigInteger ProdTree(int l, int r)
    {
        if (l > r)
            return BigInteger.ONE;
        if (l == r)
            return BigInteger.valueOf(l);
        if (r - l == 1)
            return BigInteger.valueOf(l * r);
        int m = (l + r) / 2;
        return ProdTree(l, m).multiply(ProdTree(m + 1, r));
    }

    public static BigInteger FactTree(int n)
    {
        if (n < 0)
            return BigInteger.valueOf(0);
        if (n == 0)
            return BigInteger.valueOf(1);
        if (n == 1 || n == 2)
            return BigInteger.valueOf(n);
        return ProdTree(2, n);
    }

    public static BigInteger FactEasy(int value){
        return value == 0 ? BigInteger.ONE : BigInteger.valueOf(value).multiply(FactEasy(value - 1));
    }
}
