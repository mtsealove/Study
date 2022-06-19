package Pick2Num;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int nums[][] = {{2, 1, 3, 4, 1}, {5, 0, 2, 7}};
        Solution solution = new Solution();
        for (int[] n : nums) {
            System.out.println(Arrays.toString(solution.solution(n)));
        }
    }

    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (i != j && !list.contains(sum)) {
                    list.add(sum);
                }
            }
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
