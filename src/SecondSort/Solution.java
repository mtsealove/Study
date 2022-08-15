package SecondSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        String[][] cases = {
                {"sun", "bed", "car"},
                {"abce", "abcd", "cdx"}
        };
        int[] ns = {1, 2};
        Solution solution = new Solution();
        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(solution.solution(cases[i], ns[i])));
        }
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        ArrayList<Match> list = new ArrayList<>();
        for (String str : strings) {
            list.add(new Match(str, n));
        }
        Collections.sort(list);
        for (int i = 0; i < strings.length; i++) {
            answer[i] = list.get(i).str;
        }
        return answer;
    }

    class Match implements Comparable<Match> {
        final String str;
        final char c;

        public Match(String str, int n) {
            this.str = str;
            this.c = str.charAt(n);
        }

        @Override
        public int compareTo(Match o) {
            int compare = this.c - o.c;
            if (compare == 0) {
                return this.str.compareTo(o.str);
            }
            return compare;
        }
    }
}
