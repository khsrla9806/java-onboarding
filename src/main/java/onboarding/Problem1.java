package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int addEachDigitOfPage(int page) {
        int sumOfDigit = (page / 100) + (page % 100 / 10) + (page % 10);
        return sumOfDigit;
    }

    public static int multiplyEachDigitOfPage(int page) {
        int lengthOfPageValue = String.valueOf(page).length();
        if (lengthOfPageValue == 3) {
            return (page / 100) * (page % 100 / 10) * (page % 10);
        }
        if (lengthOfPageValue == 2) {
            return (page / 10) * (page % 10);
        }
        return page;
    }

    public static int getBiggestValue(List<Integer> values) {
        return Collections.max(values);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}