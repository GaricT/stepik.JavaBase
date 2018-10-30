package chapter2;

//import java.util.HashMap;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise_24_3 {
    public static void main(String[] args) {
        String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука", "Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.", "Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?", "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.", "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!", "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println("");
        System.out.println(Exercise_24_3.printTextPerRole(roles, textLines));

    }
    private static String printTextPerRole(String[] roles, String[] textLines) {
        int j = 0;
        StringBuilder[] result = new StringBuilder[roles.length];
        StringBuilder txt = new StringBuilder("");
        for (int i = 0; i < roles.length; i++ ) {
            result[i] = new StringBuilder(roles[i] + ":\n");
        }

        for (String text: textLines) {
            result[Arrays.asList(roles).indexOf(text.substring(0, text.indexOf(':')))].append(++j + ")" + text.substring(text.indexOf(':') + 1) + '\n');
        }
        for (StringBuilder vals: result) {
            txt.append(vals + "\n");
        }
        return txt.toString();
    }
}
