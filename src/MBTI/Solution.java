package MBTI;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        String[][] surveys = {
                {"AN", "CF", "MJ", "RT", "NA"},
                {"TR", "RT", "TR"}
        };
        int[][] choices = {
                {5, 3, 2, 7, 5},
                {7, 1, 3}
        };
        Solution solution = new Solution();
        for (int i = 0; i < 2; i++) {
            System.out.println(solution.solution(surveys[i], choices[i]));
        }
    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            char first = s.charAt(0);
            char last = s.charAt(1);
            int firstValue = map.get(first);
            int lastValue = map.get(last);
            int c = choices[i];
            if (c >= 5) {
                lastValue += c - 4;
                map.put(last, lastValue);
            } else if (c < 4) {
                firstValue += 4 - c;
                map.put(first, firstValue);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map.get('R') > map.get('T') ? "R" : "T");
        sb.append(map.get('C') > map.get('F') ? "C" : "F");
        sb.append(map.get('J') > map.get('M') ? "J" : "M");
        sb.append(map.get('A') > map.get('N') ? "A" : "N");
        return sb.toString();
    }
}
