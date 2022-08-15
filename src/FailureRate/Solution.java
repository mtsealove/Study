package FailureRate;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] stages = {{2, 1, 2, 6, 2, 4, 3, 3}, {4, 4, 4, 4, 4}};
        int[] ns = {5, 4};
        Solution solution = new Solution();
        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(solution.solution(ns[i], stages[i])));
        }
    }

    public int[] solution(int N, int[] stages) {
        Match[] matches = new Match[N];
        for (int i = 1; i < N + 1; i++) {
            matches[i - 1] = new Match(i, findCount(i, stages, N + 1));
        }
        this.sort(matches);
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = matches[i].stage;
        }
        return answer;
    }

    private Match[] sort(Match[] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i].count > m[j].count) {
                    Match tmp = m[i];
                    m[i] = m[j];
                    m[j] = tmp;
                } else if (m[i].count == m[j].count) {
                    if (m[j].stage > m[i].stage) {
                        Match tmp = m[i];
                        m[i] = m[j];
                        m[j] = tmp;
                    }
                }
            }
        }
        return m;
    }

    // 실패율
    private int findCount(int n, int[] stages, int last) {
        int result = 0;
        for (int s : stages) {
            if (s == n - 1 && last != n + 1) {
                result++;
            }
        }
        boolean allSame = true;
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] != stages[0]) {
                allSame = false;
                break;
            }
        }
        if (allSame && n == last - 1) {
            return 1000000000;
        }
        return result;
    }

    class Match {
        int stage;
        int count;

        public Match(int stage, int count) {
            this.stage = stage;
            this.count = count;
        }
    }
}
