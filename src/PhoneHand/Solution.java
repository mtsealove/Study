package PhoneHand;

import java.util.Arrays;
import java.util.List;

public class Solution {


    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        List<Integer> leftNums = Arrays.asList(1, 4, 7);
        List<Integer> rightNums = Arrays.asList(3, 6, 9);
        int prevLeft = -1;
        int prevRight = -1;

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (leftNums.contains(n)) {
                sb.append("L");
                prevLeft = n;
            } else if (rightNums.contains(n)) {
                sb.append("R");
                prevRight = n;
            } else {
                int lDistance, rDistance;
                if (prevLeft == -1) {
                    lDistance = getInitialDistance(n);
                } else {
                    lDistance = getDistance(n, prevLeft);
                }
                if (prevRight == -1) {
                    rDistance = getInitialDistance(n);
                } else {
                    rDistance = getDistance(n, prevRight);
                }
                if (lDistance < rDistance) {
                    sb.append("L");
                    prevLeft = n;
                } else if (rDistance < lDistance) {
                    sb.append("R");
                    prevRight = n;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        prevRight = n;
                    } else {
                        sb.append("L");
                        prevLeft = n;
                    }
                }
            }
        }
        return sb.toString();
    }

    // 거리 구하기
    private int getDistance(int a, int b)  {
        int[][] pad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-2, 0, -2}};
        int y1 = -1, y2 = -1, x1 = -1, x2 = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (a == pad[i][j]) {
                    x1 = j;
                    y1 = i;
                } else if (pad[i][j] == b) {
                    x2 = j;
                    y2 = i;
                }
            }
        }
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    private int getInitialDistance(int n) {
        return switch (n) {
            case 0 -> 1;
            case 8 -> 2;
            case 5 -> 3;
            default -> 4;
        };
    }
}
