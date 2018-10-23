/**
 * Укажите пары эквивалентных булевских операторов.
 */
package chapter2;

public class Exercise_21_1 {
    public static void main(String[] args){
        boolean a1, a2;
        a1 = true;
        a2 = false;
        System.out.println("a1 & a2 = " + (a1 & a1 ) + ":" + (a1 == a1 ));
        System.out.println("a1 & a2 = " + (a1 & a2 ) + ":" + (a1 == a2 ));
        System.out.println("a1 & a2 = " + (a2 & a1 ) + ":" + (a2 == a1 ));
        System.out.println("a1 & a2 = " + (a2 & a2 ) + ":" + (a2 == a2 ));

        System.out.println("a1 ^ a2 = " + (a1 ^ a1 ) + ":" + (a1 != a1 ));
        System.out.println("a1 ^ a2 = " + (a1 ^ a2 ) + ":" + (a1 != a2 ));
        System.out.println("a1 ^ a2 = " + (a2 ^ a1 ) + ":" + (a2 != a1 ));
        System.out.println("a1 ^ a2 = " + (a2 ^ a2 ) + ":" + (a2 != a2 ));

        System.out.println("a1 | a2 = " + (a1 | a1 ) + ":" + (a1 || a1 ));
        System.out.println("a1 | a2 = " + (a1 | a2 ) + ":" + (a1 || a2 ));
        System.out.println("a1 | a2 = " + (a2 | a1 ) + ":" + (a2 || a1 ));
        System.out.println("a1 | a2 = " + (a2 | a2 ) + ":" + (a2 || a2 ));

        System.out.println("a1 | a2 = " + (a1 | a1 ) + ":" + (a1 != a1 ));
        System.out.println("a1 | a2 = " + (a1 | a2 ) + ":" + (a1 != a2 ));
        System.out.println("a1 | a2 = " + (a2 | a1 ) + ":" + (a2 != a1 ));
        System.out.println("a1 | a2 = " + (a2 | a2 ) + ":" + (a2 != a2 ));

    }

}
