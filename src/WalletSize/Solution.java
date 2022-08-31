package WalletSize;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][][] sizes = {
                {{60, 50}, {30, 70}, {60, 30}, {80, 40}},
                {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}},
                {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}
        };
        for (int[][] size : sizes) {
            System.out.println(solution.solution(size));
        }
    }

    public int solution(int[][] sizes) {
        ArrayList<Integer> longer = new ArrayList<>();
        ArrayList<Integer> shorter = new ArrayList<>();
        for(int [] size: sizes) {
            int x = size[0];
            int y = size[1];
            if(x > y) {
                longer.add(x);
                shorter.add(y);
            } else {
                longer.add(y);
                shorter.add(x);
            }
        }
        Collections.sort(longer);
        Collections.sort(shorter);
        return longer.get(sizes.length -1) * shorter.get(sizes.length - 1);
    }
}
