package SqrtPlus;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {121, 3};
        Solution solution = new Solution();
        for (int n : nums) {
            System.out.println(solution.solution(n));
        }
    }

    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        boolean enable = sqrt % 1 == 0;
        if (!enable) {
            return -1;
        }
        return (long) Math.pow((sqrt+1), 2);
    }
}
