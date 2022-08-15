package DivAdd;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] lrs = {
                {13, 17},
                {24, 27}
        };
        for (int i = 0; i < 2; i++) {
            System.out.println(solution.solution(lrs[i][0], lrs[i][1]));
        }
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int muti = getDivCount(i) % 2 == 0 ? 1 : -1;
            answer += i * muti;
        }
        System.out.println(Arrays.toString(new int[]{1, 3}));
        return answer;
    }

    private int getDivCount(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                result++;
            }
        }
        return result;
    }
}
