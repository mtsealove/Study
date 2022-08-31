package PhoneHand;

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
        };
        String[] hands = {
                "right", "left", "right"
        };
        Solution solution = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(solution.solution(nums[i], hands[i]));
        }
    }

    final int SHARP = -2;
    final int STAR = -1;

    public String solution(int[] numbers, String hand) {
        int leftNum = STAR, rightNum = SHARP;
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> leftSet = new HashSet<>();
        leftSet.add(1);
        leftSet.add(4);
        leftSet.add(7);
        HashSet<Integer> rightSet = new HashSet<>();
        rightSet.add(3);
        rightSet.add(6);
        rightSet.add(9);
        for(int num: numbers) {
            if(leftSet.contains(num)) {
                sb.append("L");
                leftNum = num;
            } else if(rightSet.contains(num)) {
                sb.append("R");
                rightNum = num;
            } else {
                int lDistance = getDistance(leftNum, num);
                int rDistance = getDistance(rightNum, num);
                if(lDistance<rDistance) {
                    sb.append("L");
                    leftNum = num;
                } else if(rDistance<lDistance) {
                    sb.append("R");
                    rightNum = num;
                } else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        leftNum = num;
                    } else {
                        sb.append("R");
                        rightNum = num;
                    }
                }
            }
        }
        return sb.toString();
    }

    private int getDistance(int a, int b) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {STAR, 0, SHARP}
        };
        int ax = 0, ay = 0, bx = 0, by = 0;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 3; x++) {
                if (arr[y][x] == a) {
                    ax = x;
                    ay = y;
                }
                if (arr[y][x] == b) {
                    bx = x;
                    by = y;
                }
            }
        }
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
}
