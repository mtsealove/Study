package CloseStole;

import java.util.*;

public class Solution {
    public static void main(String[] agrs) {
        int[] nums = {5, 5, 3};
        int[][] losts = {
                {2, 4},
                {2, 4},
                {3}
        };
        int[][] reserves = {
                {1, 3, 5},
                {3}, {1}
        };
        Solution solution = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(solution.solution(nums[i], losts[i], reserves[i]));
        }
    }

    public int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> reserveList = new ArrayList<>();
        ArrayList<Integer> lostList = new ArrayList<>();
        for (int l : lost) {
            lostList.add(l);
        }
        for (int r : reserve) {
            if (!lostList.contains(r)) {
                reserveList.add(r);
            }
        }
        Collections.sort(reserveList);
        Collections.sort(lostList);
        int count = n - lostList.size();
        for (int l : lostList) {
            int up = l + 1;
            int down = l - 1;
            if (reserveList.contains(down)) {
                count++;
                reserveList.remove((Integer) down);
            } else if (reserveList.contains(up)) {
                count++;
                reserveList.remove((Integer) up);
            }
        }
        return count;
    }
}
