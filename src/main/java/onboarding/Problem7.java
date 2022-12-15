package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> usersFriend = findUsersFriend(user, friends);
        List<String> friendWithUser = findFriendWithUser(user, usersFriend, friends);
        List<String> verifiedVisitors = visitors.stream()
                .filter(visitor -> !usersFriend.contains(visitor))
                .collect(Collectors.toList());
        return calculateFriendScore(friendWithUser, verifiedVisitors).stream()
                .limit(5).collect(Collectors.toList());
    }

    public static List<String> findUsersFriend(String user, List<List<String>> friends) {
        List<String> usersFriend = new ArrayList<>();
        for (List<String> data : friends) {
            if (data.contains(user)) {
                usersFriend.add(data.get(0));
                usersFriend.add(data.get(1));
            }
        }
        return usersFriend.stream().filter(data -> !data.equals(user)).collect(Collectors.toList());
    }

    public static List<String> findFriendWithUser(String user, List<String> usersFriend, List<List<String>> friends) {
        List<String> friendWithUser = new ArrayList<>();
        for (String friend : usersFriend) {
            findUsersFriend(friend, friends).stream()
                    .forEach((data) -> friendWithUser.add(data));
        }
        return friendWithUser.stream().filter(data -> !data.equals(user)).collect(Collectors.toList());
    }

    public static List<String> calculateFriendScore(List<String> friendWithUser, List<String> visitors) {
        Map<String, Integer> friendScore = new HashMap<>();
        friendWithUser.stream()
                .forEach(friend -> friendScore.put(friend, friendScore.getOrDefault(friend, 0) + 10));
        visitors.stream()
                .forEach(visitor -> friendScore.put(visitor, friendScore.getOrDefault(visitor, 0) + 1));
        return sortFriendScore(friendScore);
    }

    public static List<String> sortFriendScore(Map<String, Integer> friendScore) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(friendScore.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> object1, Map.Entry<String, Integer> object2) {
                if (object1.getValue() == object2.getValue()) {
                    return object1.getKey().compareTo(object2.getKey());
                }
                return object2.getValue().compareTo(object1.getValue());
            }
        });
        return entries.stream().map(object -> object.getKey()).collect(Collectors.toList());
    }
}
