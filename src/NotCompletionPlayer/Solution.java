package NotCompletionPlayer;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
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
        Solution solution = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(solution.solution(participants[i], completions[i]));
        }
    }

    public String solution(String[] participant, String[] completion) {
        LinkedList<String> p = new LinkedList<>();
        Arrays.sort(completion);
        Arrays.sort(participant);
        p.addAll(Arrays.asList(participant));
        for (String c : completion) {
            p.remove(c);
        }
        return p.get(0);
    }
}
