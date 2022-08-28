package KNums;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(array, commands)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] c : commands) {
            int i = c[0];
            int j = c[1];
            int k = c[2];
            int[] sliced = slice(array, i, j);
            Arrays.sort(sliced);
            answer[idx] = sliced[k - 1];
            idx ++;
        }
        return answer;
    }

    private int[] slice(int[] array, int start, int end) {
        int[] result = new int[end - start + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i + start - 1];
        }
        return result;
    }
}
