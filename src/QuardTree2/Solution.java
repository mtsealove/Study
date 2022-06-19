package QuardTree2;

import java.util.Arrays;

public class Solution {
    // 쿼드 트리 압축
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 배열의 개수는 4배수로 주어짐
        int[][][] arrs = {
                {
                        {1, 1, 0, 0},
                        {1, 0, 0, 0},
                        {1, 0, 0, 1},
                        {1, 1, 1, 1}
                },
                {
                        {1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1}}
        };
        for (int[][] arr : arrs) {
            System.out.println(Arrays.toString(solution.solution(arr)));
        }
    }

    public int[] solution(int[][] arr) {
        int[] answer = {};
        compress(arr, arr.length, 0, 0);
        System.out.println("zero: " + zero);
        System.out.println("one: " + one);
        return answer;
    }

    int zero = 0, one = 0;

    void compress(int[][] arr, int n, int x, int y) {
        //기저 사례
        if (n == 1) {
            System.out.println(arr[y][x]);
            return;
        }
        boolean bIsZero = true;
        boolean bIsOne = true;

        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (arr[i][j] == 1) {
                    bIsZero = false;
                } else {
                    bIsOne = false;
                }

                if (!bIsZero && !bIsOne) {
                    break;
                }

            }

            if (!bIsZero && !bIsOne) //두개 다 섞여있다면
            {
                break; //바로 중단
            }
        }
        if (bIsZero) {
//            System.out.println(0);
            zero++;
        } else if (bIsOne) {
//            System.out.println(1);
            one++;
        } else {
            compress(arr, n / 2, y, x); //2사분면
            compress(arr, n / 2, y, x + n / 2); //1사분면
            compress(arr, n / 2, y + n / 2, x); //3사분면
            compress(arr, n / 2, y + n / 2, x + n / 2); //4사분면
        }
    }
}
