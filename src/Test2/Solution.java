package Test2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] c = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution.solution(arr, c)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for (int[] command : commands) {
            int x = command[0] - 1;
            int y = command[1] - 1;
            int k = command[2];
            int[] pick = new int[y - x + 1];
            for (int i = 0; i < pick.length; i++) {
                pick[i] = array[i + x];
            }
            Arrays.sort(pick);
            answer[index] = pick[k-1];
            index ++;
        }
        return answer;
    }
}
