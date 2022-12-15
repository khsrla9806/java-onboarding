package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return countEachNumberOfMoney(money);
    }

    public static List<Integer> countEachNumberOfMoney(int money) {
        int[] kindOfMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> result = new ArrayList<>();
        for (int value : kindOfMoney) {
            result.add(money / value);
            money %= value;
        }
        return result;
    }
}
