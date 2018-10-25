package chapter2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Exercise_24_2 {
    public static void main(String[] args) {
//        int[] a1 = {};
//        int[] a2 = {};
        int[] a1 = new int[29];
        int[] a2 = new int[9];
        for (int i = 0; i< a1.length; i++){
            a1[i] = i;
        }
        for (int i = 0; i< a2.length; i++){
            a2[i] = i;
        }


//        int[] a1 = {0, 2, 2};
//        int[] a2 = {1, 3};
        System.out.println(Arrays.toString(mergeArrays(a1, a2)));

    }
    public static int[] mergeArrays(int[] a1, int[] a2) {
//        Your code complexity score is 12.88 (best for this step is 10.05).
        int b1 = 0;
        int b2 = 0;
        int[] res = new int[a1.length + a2.length];

        for (int i = 0; i< a1.length + a2.length; i++){
            res[i] = (b1 < a1.length) ? ((b2 < a2.length) ? ((a1[b1] < a2[b2])? a1[b1++] : a2[b2++]) : (a1[b1++])) : a2[b2++];
        }

        return res; // your implementation here
    }
}
