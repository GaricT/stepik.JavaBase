package chapter5;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/*
Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
 */
public class Exercise_53_1 {
    public static void main(String[] args) {
        class NullStream extends InputStream{
            int pos = 0;
            byte[] data = new byte[]{48, 49, 50, 51};


            @Override
            public int read() throws IOException {
                return (pos < data.length)? data[pos++]: -1;
            }
        };

        try {
            System.out.println(readAsString(new NullStream(), StandardCharsets.US_ASCII));
        }
        catch (IOException e){

        }


    }
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // your implementation here
        int data;
        StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, charset);
        while ((data = in.read()) >= 0) {
            out.append((char) data);
        }
        return out.toString();
    }
}
