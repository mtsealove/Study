package Lottos;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /*
        주어진 번호의 로또의 최대 순위와 최저 순위 구하기
     */

    public static void main(String[] args) {
        var solution = new Solution();
        int lottos[][] = {{44, 1, 0, 0, 31, 25},
                {0, 0, 0, 0, 0, 0},
                {45, 4, 35, 20, 3, 9}};
        int winNums[][] = {{31, 10, 45, 1, 6, 19},
                {38, 19, 20, 40, 15, 25},
                {20, 9, 3, 45, 4, 35}};
        int results[][] = {{3, 5}, {1, 6}, {1, 1}};
        for (int i = 0; i < lottos.length; i++) {
            System.out.println(Arrays.toString(solution.solution(lottos[i], winNums[i])));
        }
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int min = getWin(lottos, win_nums);
        int max = min - getHope(lottos);
        if (max == 0) { // 0등은 존재 하지 않기 때문에 1등으로 취급
            max = 1;
        }
        return new int[]{max, min};
    }

    // 0의 개수는 추가로 획득할 수 있는 개수
    private int getHope(int[] lottos) {
        int result = 0;
        for (int l : lottos) {
            if (l == 0) {
                result++;
            }
        }
        return result;
    }

    // 해당 번호의 등수 구하기(최소치)
    private int getWin(int[] lotto, int[] winNum) {
        ArrayList<Integer> win = new ArrayList<>();
        int result = 7;
        for (int w : winNum) {
            win.add(w);
        }
        for (int l : lotto) {
            if (win.contains(l)) {
                result--;
            }
        }
        if (result == 7) {
            return 6;
        }
        return result;
    }

    private int[] quickSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }
        int pivot = nums[n - 1];
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int num = nums[i];
            if (num < pivot) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
        int[] result = new int[n];
        int i = 0;
        for (int l : left) {
            result[i] = l;
            i++;
        }
        result[i] = pivot;
        i++;
        for (int r : right) {
            result[i] = r;
            i++;
        }
        return result;
    }
}
