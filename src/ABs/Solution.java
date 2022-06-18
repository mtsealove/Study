package ABs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
    }

    public int solution(int[] numbers) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int n : numbers) {
            nums.add(n);
        }
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (!nums.contains(i)) {
                result += i;
            }
        }
        return result;
    }
}
