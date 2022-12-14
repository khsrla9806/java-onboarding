package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try {
            validateInput(pobi, crong);
            answer = playGame(pobi, crong);
        } catch (IllegalArgumentException exception) {
            answer = -1;
        }
        return answer;
    }

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

    public static int getWinner(int numberOfPobi, int numberOfCrong) {
        if (numberOfPobi > numberOfCrong) {
            return 1;
        }
        if (numberOfPobi < numberOfCrong) {
            return 2;
        }
        return 0;
    }

    public static void validateInput(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) % 2 == 0
                || pobi.get(1) % 2 == 1
                || crong.get(0) % 2 == 0
                || crong.get(1) % 2 == 1) {
            throw new IllegalArgumentException("왼쪽 혹은 오른쪽 페이지가 잘못 입력되었습니다.");
        }

        if (pobi.get(1) != pobi.get(0) + 1 || crong.get(1) != crong.get(0) + 1) {
            throw new IllegalArgumentException("잘못된 페이지 입력값입니다.");
        }
    }

    public static int playGame(List<Integer> pobi, List<Integer> crong) {
        List<Integer> pobiValues = new ArrayList<>();
        List<Integer> crongValues = new ArrayList<>();
        pobi.stream().forEach((value) -> {
            pobiValues.add(addEachDigitOfPage(value));
            pobiValues.add(multiplyEachDigitOfPage(value));
        });
        crong.stream().forEach((value) -> {
            crongValues.add(addEachDigitOfPage(value));
            crongValues.add(multiplyEachDigitOfPage(value));
        });
        return getWinner(getBiggestValue(pobiValues), getBiggestValue(crongValues));
    }
}