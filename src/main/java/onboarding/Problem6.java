package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String userNickname = forms.get(i).get(1);
            if (userNickname.length() == 1) {
                continue;
            }
            List<String> compareData = getSubString(userNickname);
            for (int j = i + 1; j < forms.size(); j++) {
                String targetNickname = forms.get(j).get(1);
                if (checkDuplicate(targetNickname, compareData)) {
                    answer.add(forms.get(j).get(0));
                    answer.add(forms.get(i).get(0));
                }
            }
        }
        return answer.stream().distinct().sorted().collect(Collectors.toList());
    }

    public static List<String> getSubString(String target) {
        List<String> result = new ArrayList<>();
        for (int i = 2; i < target.length(); i++) {
            result.add(target.substring(i - 2, i));
        }
        return result;
    }

    public static boolean checkDuplicate(String target, List<String> compareData) {
        for (String data : compareData) {
            if (target.contains(data)) {
                return true;
            }
        }
        return false;
    }
}
