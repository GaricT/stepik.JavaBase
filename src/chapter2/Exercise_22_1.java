package chapter2;

public class Exercise_22_1 {
    public static void main(String[] args) {
        char c = '\\';
        int a = 32;
//        Your code complexity score is 2.24 (best for this step is 2.24).
        c = (char)('\\' + a);
        c = (char)(92 + a);
//        Your code complexity score is 2.45 (best for this step is 2.24).
        c = (char)(a+=92);
//        Your code complexity score is 3.0 (best for this step is 2.24).
        c+=a;
        System.out.println(Integer.toHexString(c) + ":" + c);
        System.out.println(c + '\u0000');
    }
}
