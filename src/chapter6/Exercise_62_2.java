package chapter6;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercise_62_2 {
    public static void main(String[] args) {
        String input;
        input = "1 2 3 4 5 6";
        input = "1 2 3 4 5 6";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);

        new Exercise_62_2().convert();

    }
    public void convert(){
        Scanner s = new Scanner(System.in);
        LinkedList vals = new LinkedList<String>();

        for (int i = 0; s.hasNext(); ){
            if (i == 1){
                vals.addFirst(String.valueOf(s.nextInt()));
            }
            else s.nextInt();
            i = ++i % 2;
        }
        System.out.println(.join(" ", vals));

    }
}
