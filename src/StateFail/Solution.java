package StateFail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int[] ns = {5, 4};
        int[][] stages = {{2, 1, 2, 6, 2, 4, 3, 3}, {4, 4, 4, 4, 4}};
        Solution solution = new Solution();
        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(solution.solution(ns[i], stages[i])));
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] result = new int[N];
        ArrayList<Match> matches = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int stage = i + 1;
            double rate = getRate(stages, stage);
            matches.add(new Match(stage, rate));
        }
        Collections.sort(matches);

        for (int i = 0; i < N; i++) {
            result[i] = matches.get(i).stage;
        }

        return result;
    }

    private double getRate(int[] stages, int n) {
        double competitor = 0;
        double fail = 0;
        for (int s : stages) {
            if (s >= n) {
                competitor++;
                if (n == s) {
                    fail++;
                }
            }
        }
        return fail / competitor;
    }

    private class Match implements Comparable<Match> {
        int stage;
        double rate;

        public Match(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }

        @Override
        public int compareTo(Match obj) {
            if (obj.rate < this.rate) {
                return -1;
            } else if (obj.rate > this.rate) {
                return 1;
            } else {
                return Integer.compare(this.stage, obj.stage);
            }
        }
    }
}
