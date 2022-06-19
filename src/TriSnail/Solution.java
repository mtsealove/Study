package TriSnail;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] results = {{1, 2, 9, 3, 10, 8, 4, 5, 6, 7},
                {1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9},
                {1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11}};
//        System.out.println(solution.getIndex(2, 4));
        for (int i = 0; i < 3; i++) {
            String correct = Arrays.toString(results[i]);
            String solve = Arrays.toString(solution.solution(i + 4));
            System.out.println(solve);
            System.out.println(solve.equals(correct));
        }
    }

    // 삼각형 달팽이
    public int[] solution(int n) {
        int s = sum(n);
        int[] answer = new int[s];
        int max = n;
        int round = 0;
        int x = 0, y = 0;
        int current = 0; // 한 방향의 루틴(3개가 1세트)
        String direction = "ld"; //  "ld" | "r" | "lu"(좌측 하단 | 우측 | 촤측 상단)
        for (int i = 1; i < s + 1; i++) {
            int idx = getIndex(x, y); // 모든 수에 대해 인덱스 계산
            answer[idx] = i;
            round++; // 한 방향 내에서 이동한 횟수 추가
            if (round >= max) {
                current++; // 루틴 하나 명시
                round = 0;
                max -= 1;
                // 새로운 방향 계산
                direction = switch (direction) {
                    case "ld" -> "r";
                    case "r" -> "lu";
                    default -> "ld";
                };
            }
            // 방향에 따라 좌표 변경
            switch (direction) {
                case "ld" -> {
                    y++;
                    x = current / 3;
                }
                case "r" -> x++;
                default -> {
                    y--;
                    x--;
                }
            }
        }
        return answer;
    }

    // 좌표 기준으로 인덱스 계산
    private int getIndex(int x, int y) {
        int s = sum(y);
        return s + x;
    }
    // n 까지의 합
    private int sum(int n) {
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            result += i;
        }
        return result;
    }
}
