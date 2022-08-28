package MaxBudget;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] teams = {{1, 3, 2, 5, 4}, {2, 2, 3, 3}};
        int[] budgets = {9, 10};
        for (int i = 0; i < 2; i++) {
            System.out.println(solution.solution(teams[i], budgets[i]));
        }
    }

    public int solution(int[] d, int budget) {
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < i; j++) {
                if (d[i] < d[j]) {
                    int tmp = d[j];
                    d[j] = d[i];
                    d[i] = tmp;
                }
            }
        }
        int i = 0;
        while (budget >= 0) {
            if (i >= d.length) {
                break;
            }
            if (budget - d[i] >= 0) {
                budget -= d[i];
                i++;
            } else {
                break;
            }
        }
        return i;
    }
}
