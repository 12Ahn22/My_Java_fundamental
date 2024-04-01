package 낙서장;

import java.util.Arrays;
import java.util.List;

public class Ex {
    public static void main(String[] args) {
        String str = "AaSssDdd";
        char[] list = str.toCharArray();
        for (char c : list) {
            if (Character.isUpperCase(c)) {
                System.out.print(Character.toLowerCase(c));
            } else {
                System.out.print(Character.toUpperCase(c));
            }
        }
        String str1 = "!@#$%^&*(\\'\"<>?:;";

        String str2 = "abcde";
        List<String> list2 = List.of(str2.split(""));
        list2.forEach(System.out::println);

        System.out.println(str2.substring(0,2));
        str2.length()
    }
}
