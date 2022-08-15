package CombPrimeNumber;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 7, 6, 4};
        System.out.println(solution.solution(arr));
    }

    boolean[] sieve = new boolean[3001];

    Solution() {
        for (int i = 2; i * i < sieve.length; i += 1) {
            if (!sieve[i]) break;
            for (int j = i + i; j < sieve.length; j += i) {
                sieve[j] = false;
            }
        }
    }

    public int solution(int[] nums) {
        System.out.println(Arrays.toString(sieve));
        int answer = -1;
        for (int i = 0; i < nums.length; i += 1) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int index = nums[i] + nums[j] + nums[k];
                    if (sieve[index]) {
                        answer += 1;
                    }
                }
            }
        }
        return answer;
    }

}
