package chapter6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise_62_1 {
    public static void main(String[] args) {
        HashSet<Integer> a1 = new HashSet<Integer>(Arrays.asList(new Integer[]{1, 2, 3}));
        HashSet<Integer> a2 = new HashSet<Integer>(Arrays.asList(new Integer[]{1, 2, 0}));
        HashSet<Integer> a3 = (HashSet)symmetricDifference(a1, a2);
        System.out.println(Arrays.toString(a3.toArray()));
    }
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> dif = new HashSet(set1);
        Set<T> res = new HashSet(set1);
        dif.retainAll(set2);
        res.addAll(new HashSet(set2));
        res.removeAll(dif);
        return res;
    }
}
