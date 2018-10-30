package chapter2;
// Your code complexity score is 31.92 (best for this step is 21.42).

import java.util.HashMap;
import java.util.Map;

public class Exercise_24_3_1 {
    public static void main(String[] args) {
        String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука", "Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.", "Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?", "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.", "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!", "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println("");
        System.out.println(Exercise_24_3_1.printTextPerRole(roles, textLines));

    }
    private static String printTextPerRole(String[] roles, String[] textLines) {
        Map<String, StringBuilder> roles_map = new HashMap<String, StringBuilder>();
        int pos;
        int num = 0;
        StringBuilder result = new StringBuilder();
        for (String name: roles) {
            roles_map.put(name, new StringBuilder());
        }
        StringBuilder a = new StringBuilder();

        for (String text: textLines) {
            num++;
            pos = text.indexOf(':');
            roles_map.get(text.substring(0, pos)).append(num + ")" + text.substring(++pos) + '\n');
        }
        for (String name: roles) {
            result.append(name + ":\n");
            result.append(roles_map.get(name));
            result.append("\n");

        }
        return result.toString();
    }
}
