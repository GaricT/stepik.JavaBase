package chapter2;

/*
 ** Степень двойки
 */

import java.lang.reflect.Array;

public class Exercise_22_3 {
    public static void main(String[] args) {
        int val = -16;
        boolean res; // (val && ~(val & (val - 1));
//        System.out.println((val == 0) ? true : (val & (val - 1)));
        val = Math.abs(val);

//        Your code complexity score is 5.48 (best for this step is 2.24).
        res = (val == 0) ? true : (val & (val - 1)) == 0;

//        Your code complexity score is 2.24 (best for this step is 2.24).
//        res = val<0?(-val&-val-1)==0:val==0?false:(val&val-1)==0;
        System.out.println(res);


    }
}
