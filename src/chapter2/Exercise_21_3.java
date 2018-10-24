package chapter2;
import java.util.GregorianCalendar;

public class Exercise_21_3 {
    public static void main(String[] args) {
        int year = 99;
        int count, total = 0;
        GregorianCalendar calend = new GregorianCalendar();
        for (int i = 1; i <= year; i++){
            if (calend.isLeapYear(i))
                total++;
        }

//        count = (int)(year * 0.2425f);

        count = year / 4 - year / 100 + year / 400;
        System.out.println(count + " = " + total);
        System.out.println(calend.isLeapYear(1900));
        System.out.println(calend.isLeapYear(1300));
    }
}
