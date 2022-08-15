package MinMaxNum;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] cases = {
                {3, 12},
                {2, 5},
        };
        Solution solution = new Solution();
        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(solution.solution(cases[i][0], cases[i][1])));
        }
    }

    public int[] solution(int n, int m) {
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        int divMax = 1;
        for (int i = max; i >= 1; i--) {
            if (n % i == 0 && m % i == 0) {
                divMax = i;
                break;
            }
        }
        int multiMin = n * m;
        for (int i = min; i < n * m; i++) {
            if (i % n == 0 && i % m == 0) {
                multiMin = i;
                break;
            }
        }
        return new int[]{divMax, multiMin};
    }
}
