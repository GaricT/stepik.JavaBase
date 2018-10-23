/**
 * Реализуйте метод, возвращающий true, если среди четырех его аргументов
 * ровно два истинны (любые). Во всех остальных случаях метод должен возвращать
 * false.
 */
package chapter2;


public class Exercise_21_2 {
    private static boolean getValBool(int i, int pos){
        // Преобразование битов в логические значения
        return (((i >> pos) & 1) != 0);
    }

    private static boolean tstExpression1(boolean... args){
        // Тестовое выражение: Вариант 1
        return !(args[0] ^ args[1] ^ args[2] ^ args[3]) && ((args[0] && args[1] && args[2] && args[3]) == !(args[0] || args[1] || args[2] || args[3]));
    }

    private static boolean tstExpression2(boolean... args){
        // Тестовое выражение: Варитант 2
        return (((args[0] == true) ? 1: 0) + ((args[1] == true) ? 1: 0) + ((args[2] == true) ? 1: 0) + ((args[3] == true) ? 1: 0) == 2);
    }

    private static int calcOnes(String[] arg){
        // Считаем количество единичек в двоичной записи
        int count = 0;
        for (int j = 0; j < arg.length; j++){
            if (arg[j].equals("1")) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int pos = 4; // количество переменных
        int max = (int)(Math.pow(2, pos) - 1);
        int count = 0;
        boolean expr1, expr2 ;
        String[] vals;

        for (int i = 0; i <= max; i++) {
            vals = Integer.toBinaryString(i).split("");
            count = calcOnes(vals);
            expr1 = tstExpression1(getValBool(i, 0), getValBool(i, 1), getValBool(i, 2), getValBool(i, 3));
            expr2 = tstExpression2(getValBool(i, 0), getValBool(i, 1), getValBool(i, 2), getValBool(i, 3));
            if (expr1 != (count == 2)){
                // Тест коррекности работы Варианта 1
                System.out.println(String.join("", vals) + " " + i + " " + expr1);
            }
            if (expr1 != expr1){
                // Сравнение результатов работы Вариантов 1 и 2
                System.out.println(expr1 + " != " + expr2 + ": " + String.join("", vals) + " " + i );
            }

        }
        // При успешном завершении работы вывод будет пустой
    }
}
