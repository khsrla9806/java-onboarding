package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<String> convertedData = cryptogramToList(cryptogram);
        while (isDuplication(convertedData)) {
            removeDuplication(convertedData);
        }
        StringBuilder result = new StringBuilder("");
        convertedData.stream().forEach((value) -> result.append(value));
        return result.toString();
    }

    public static List<String> cryptogramToList(String cryptogram) {
        List<String> convertedData = new ArrayList<>(Arrays.asList(cryptogram.split("")));
        return convertedData;
    }

    public static void removeDuplication(List<String> inputData) {
        int index = 0;
        while (index < inputData.size() - 1) {
            if (inputData.get(index).equals(inputData.get(index + 1))) {
                removePart(inputData.subList(index, inputData.size()));
            }
            index++;
        }
    }

    public static void removePart(List<String> subData) {
        int index = 0;
        for (int i = 1; i < subData.size(); i++) {
            if (!subData.get(i).equals(subData.get(i - 1))) {
                break;
            }
            index = i + 1;
        }
        subData.subList(0, index).clear();
    }

    public static boolean isDuplication(List<String> data) {
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).equals(data.get(i - 1))) {
                return true;
            }
        }
        return false;
    }
}
