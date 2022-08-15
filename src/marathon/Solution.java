package marathon;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] participants = {
                {"leo", "kiki", "eden"},
                {"marina", "josipa", "nikola", "vinko", "filipa"},
                {"mislav", "stanko", "mislav", "ana"}
        };
        String[][] completions = {
                {"eden", "kiki"},
                {"josipa", "filipa", "marina", "nikola"},
                {"stanko", "ana", "mislav"}
        };
        for (int i = 0; i < 3; i++) {
            System.out.println(solution.solution(participants[i], completions[i]));
        }
    }

    public String solution(String[] participant, String[] completion) {

        for (int i = 0; i < participant.length; i++) {
            for (int j = i + 1; j < participant.length; j++) {
                if (participant[i].equals(participant[j])) {
                    return participant[j];
                }
            }
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(completion));
        for (String p : participant) {
            if (!set.contains(p)) {
                return p;
            }
        }
        return "";
    }
}
