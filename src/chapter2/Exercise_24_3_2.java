// Your code complexity score is 28.3 (best for this step is 21.42).
package chapter2;

//import java.util.HashMap;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Exercise_24_3_2 {
    public static void main(String[] args) {
        String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука", "Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.", "Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?", "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.", "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!", "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println("");
        System.out.println(Exercise_24_3_2.printTextPerRole(roles, textLines));

    }
    private static String printTextPerRole(String[] roles, String[] textLines) {
        Map<String, StringBuilder> roles_map = new LinkedHashMap<String, StringBuilder>();
        int pos;
        int num = 0;
        StringBuilder result = new StringBuilder();
        for (String name: roles) {
            roles_map.put(name, new StringBuilder(name + ":\n"));
        }
    
        for (String text: textLines) {
            pos = text.indexOf(':');
            roles_map.get(text.substring(0, pos)).append(++num + ")" + text.substring(++pos) + '\n');
        }
        for (Map.Entry<String, StringBuilder> entry : roles_map.entrySet()){
            result.append(entry.getValue() + "\n");

        }
        return result.toString();
    }
}
