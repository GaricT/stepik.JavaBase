package chapter2;
/*
** Автоматическое преобразование типов
 */

public class Exercise_22_2 {
    public static void main(String[] args) {
        System.out.println("");

        char a_char = 's';
        Character a_Char = 's';
        String a_String = "1";
        byte a3_byte = 's';
        int a_int = 2;
        float a_float = 2;
        long a_long = 2;
        boolean a_bool = true;

//        a_char = a3_byte;
        a_Char = a_char;
        a_float = a_long;
//        a_long = a_float;
//        a_int = a_String;
        a_int = a_char;
        a_long = a_int;
//        a_bool = a_int;


        System.out.println(a_char + ":" + a_Char + ":" + a_String + ":" + a3_byte + ":" + a_int + ":" + a_float + ":" + a_long);


    }
}
