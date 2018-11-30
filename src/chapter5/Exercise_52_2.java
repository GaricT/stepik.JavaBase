package chapter5;

import java.io.*;
import java.util.Arrays;

/*
  Преобразовывает переводы строк из формата Windows в формат Unix.
 */
public class Exercise_52_2{
    public static void main(String[] args) throws IOException{
        byte[] inputBytes =    { 65, 13, 10, 10, 13 };
        ByteArrayInputStream in = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(outputStream);

        System.setIn(in);

        PrintStream old = System.out;
        System.setOut(printStream);

        new Exercise_52_2().convert();

        System.setOut(old);
        System.out.println(Arrays.toString(outputStream.toByteArray()));
    }
    public void convert() throws IOException{
        InputStreamReader inputStream = new InputStreamReader(System.in);
        OutputStreamWriter outputStream = new OutputStreamWriter(System.out);
        int data;
        int prev = -1;

        while ((data = inputStream.read()) > 0) {
            if (((prev != 13) || (data != 10)) && (prev != -1)){
                outputStream.write(prev);
            }
            prev = data;
        }
        if (prev > 0) {
            outputStream.write(prev);
            outputStream.flush();
        }
    }
}
