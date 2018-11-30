package chapter5;

import java.io.*;
import java.util.Scanner;

public class Exercise_53_2 {
    public static void main(String[] args) throws IOException {
        String input = "1 2 3";
        input = "a1 b2 c3";
        input = "a1 1 b2 c3";
//        input = "-1e3\n18 .111 11bbb";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(outputStream);

        System.setIn(in);
        PrintStream old = System.out;
        System.setOut(printStream);

        new Exercise_53_2().convert();

        System.setOut(old);
        System.out.println(outputStream);
    }

    public void convert() throws IOException{
        Scanner s = new Scanner(System.in);
        Double result = 0d;
        while (s.hasNext()){
            try{
                result += Double.valueOf(s.next());
            }
            catch(NumberFormatException ex){

            }
        }
        System.out.println(String.format("%1$.6f", result));
    }
}
