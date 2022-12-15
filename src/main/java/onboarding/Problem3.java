package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        return countNumberOfClap(number);
    }

    public static int countNumberOfClap(int number) {
        int count = 0;
        List<Integer> numbersToCheck = List.of(3, 6, 9);
        for (int i = 1; i <= number; i++) {
            long temp = Arrays.stream(String.valueOf(i).split(""))
                    .filter((digit) -> numbersToCheck.contains(Integer.valueOf(digit)))
                    .count();
            count += temp;
        }
        return count;
    }
}
