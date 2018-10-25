package chapter2;

public class Exercise_23_2 {
    public static void main(String[] args) {
        String text = "Madam, I'm Adam!";
        boolean res;
        text = text.replaceAll("[^a-zA-Z0-9]+", "");

//        Your code complexity score is 8.54 (best for this step is 8.54).
        res = text.equalsIgnoreCase(new StringBuffer(text).reverse().toString());

        System.out.println(res);
    }

}
