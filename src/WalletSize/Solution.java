package WalletSize;

import java.util.ArrayList;
import java.util.HashSet;

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
        int answer = 0;
        HashSet<Integer> len = new HashSet<>();
        // 돌리기
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][1] > sizes[i][0]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            len.add(sizes[i][0]);
            len.add(sizes[i][1]);
        }
        int maxX = 0;
        int maxY = 0;
        for(int[] s: sizes) {
            for(int x: len) {

                /*
                if(x> s[0] && ) {
//                    maxX =
                }

                 */
            }
        }

        return answer;
    }

    private boolean isFit(int[] wallet, int[] card) {
        if (wallet[0] < card[0] && wallet[1] < card[1]) {
            return true;
        }
        return wallet[0] < card[1] && wallet[1] < card[0];
    }
}
