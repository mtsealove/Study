package Binary;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long[] cases = {2, 7};
        System.out.println(Arrays.toString(solution.solution(cases)));
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int i = 0;
        for (long num : numbers) {
            String ogBinary = decimalToBinary(num);
            long compareNum = num + 1;
            while (true) {
                String binary = decimalToBinary(compareNum);
                if (getCount(ogBinary, binary) <= 2) {
                    answer[i] = compareNum;
                    break;
                }
                compareNum++;
            }
            i++;
        }
        return answer;
    }

    public String decimalToBinary(long number) {
        // Size of the integer is 32 bits
        StringBuilder sb = new StringBuilder();
        int size = 0;
        for (long x = number - 1; x >= 0; x--) {
            long k = number >> x;
            if ((k & 1) > 0) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            size++;
        }

        for (int i = 0; i < (150 - size); i++) {
            sb.insert(0, 0);
        }
        return sb.toString();
    }

    private int getCount(String og, String compare) {
        int count = 0;
        for (int i = 0; i < og.length(); i++) {
            if (og.charAt(i) != compare.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
