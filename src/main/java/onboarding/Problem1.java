package onboarding;

import java.util.List;

class Problem1 {
    public static int addEachDigitOfPage(int page) {
        int sumOfDigit = (page / 100) + (page % 100 / 10) + (page % 10);
        return sumOfDigit;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}