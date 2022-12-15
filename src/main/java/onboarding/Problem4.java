package onboarding;

import java.util.Arrays;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        Arrays.stream(word.split(""))
                .forEach((value) -> answer.append(convertText(value)));

        return answer.toString();
    }

    public static String convertText(String text) {
        if (Character.isUpperCase(text.charAt(0))) {
            char convertedText = (char)((int)'A' + (int)'Z' - (int)text.charAt(0));
            return String.valueOf(convertedText);
        }

        if (Character.isLowerCase(text.charAt(0))) {
            char convertedText = (char)((int)'a' + (int)'z' - (int)text.charAt(0));
            return String.valueOf(convertedText);
        }
        return text;
    }
}
