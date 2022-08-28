package TrainingLost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] ns = {5, 5, 3};
        int[][] losts = {{2, 4}, {2, 4}, {3}};
        int[][] resreves = {{1, 3, 5}, {3}, {1}};

        Solution solution = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(solution.solution(ns[i], losts[i], resreves[i]));
        }
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int cnt = n - lost.length;
        boolean reserved[] = new boolean[reserve.length];
        boolean losted[] = new boolean[lost.length];

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 본인이 잃어버린것 체크
        for (int a = 0; a < lost.length; a++) {
            for (int b = 0; b < reserve.length; b++) {
                if (lost[a] == reserve[b]) {
                    reserved[b] = true;
                    losted[a] = true;
                    cnt += 1;
                    break;
                }
            }
        }

        for (int a = 0; a < lost.length; a++) {
            for (int b = 0; b < reserve.length; b++) {
                int gap = Math.abs(lost[a] - reserve[b]);
                if ((gap <= 1) && !reserved[b] && !losted[a]) {
                    cnt += 1;
                    losted[a] = true;
                    reserved[b] = true;
                    break;
                }
            }
        }
        return cnt;
    }

    private boolean contains(int[] arr, int n) {
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                result = true;
                break;
            }
        }
        return result;
    }
}
