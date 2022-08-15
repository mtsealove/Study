package SecretRoom;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] arr1s = {
                {9, 20, 28, 18, 11},
                {46, 33, 33, 22, 31, 50},
                {0, 0, 0, 0, 0}
        };
        int[][] arr2s = {
                {30, 1, 21, 17, 28},
                {27, 56, 19, 14, 14, 10},
                {30, 1, 21, 17, 28}
        };
        int[] ns = {5, 6, 5};
        Solution solution = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(solution.solution(ns[i], arr1s[i], arr2s[i])));
        }
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        boolean[][] bArr1 = new boolean[n][n];
        boolean[][] bArr2 = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            bArr1[i] = toBinary(arr1[i], n);
            bArr2[i] = toBinary(arr2[i], n);
        }
        System.out.println(Arrays.deepToString(bArr2));
        boolean[][] bArr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bArr[i][j] = bArr1[i][j] || bArr2[i][j];
            }
        }
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            boolean[] arr = bArr[i];
            StringBuilder sb = new StringBuilder();
            for (boolean b : arr) {
                sb.append(b ? "#" : " ");
            }
            result[i] = sb.toString();
        }
        return result;
    }

    public boolean[] toBinary(long number, int n) {
        boolean[] result = new boolean[n];
        ArrayList<Boolean> list = new ArrayList<>();
        for (int x = (int)number - 1; x >= 0; x--) {
            int k = (int)number >> x;
            list.add((k & 1) > 0);
        }
        while (list.size() < n) {
            list.add(0, false);
        }
        for (int i = 0; i < n; i++) {
            result[n - i - 1] = list.get(list.size() - i - 1);
        }
        return result;
    }
}
