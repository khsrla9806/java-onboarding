package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static List<String> cryptogramToList(String cryptogram) {
        return Arrays.stream(cryptogram.split(""))
                .collect(Collectors.toList());
    }
}
