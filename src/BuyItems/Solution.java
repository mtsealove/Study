package BuyItems;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] departments = {
                {1, 3, 2, 5, 4},
                {2, 2, 3, 3}
        };
        int[] budgets = {9, 10};
        for (int i = 0; i < 2; i++) {
            System.out.println(solution.solution(departments[i], budgets[i]));
        }
    }

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int tmp = 0;
        int i = 0;
        while(tmp < budget) {
            tmp += d[i];
            i++;
            if (tmp > budget) {
                i--;
                break;
            }
            if(i == d.length) {
                break;
            }
        }
        return i;
    }

}
