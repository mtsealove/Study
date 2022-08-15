package NoLinear;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] cases = {
                {1, 1, 3, 3, 0, 1, 1},
                {4, 4, 4, 3, 3}
        };
        Solution solution = new Solution();
        for (int[] arr : cases) {
            System.out.println(Arrays.toString(solution.solution(arr)));
        }
    }

    public int[] solution(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();
        int prev = -1;
        for (int n : arr) {
            if(n != prev) {
                list.add(n);
            }
            prev = n;
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
