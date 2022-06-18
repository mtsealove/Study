package SelectPocketmon;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[][] cases = {{3, 1, 2, 3}, {3, 3, 3, 2, 2, 4}, {3, 3, 3, 2, 2, 2}};
        Solution solution = new Solution();
        for (int[] c : cases) {
            System.out.println(solution.solution(c));
        }
    }

    public int solution(int[] nums) {
        int maxN = nums.length / 2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int n : nums) {
            if (!arrayList.contains(n)) {
                arrayList.add(n);
            }
        }
        return Math.min(arrayList.size(), maxN);
    }
}
