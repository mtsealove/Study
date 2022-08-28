package Add3Prime;

public class Solution {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {1, 2, 7, 6, 4}};
        Solution solution = new Solution();
        for (int i = 0; i < 2; i++) {
            System.out.println(solution.solution(nums[i]));
        }
    }

    int count = 0;

    public int solution(int[] nums) {
        count = 0;
        boolean[] visited = new boolean[nums.length];
        comb(nums, visited, 0, 3);
        return count;
    }

    private void comb(int[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {
            checkSum(arr, visited);
        } else {
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
    private void checkSum(int[] arr, boolean[] visited) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                sum += arr[i];
        }
        if (isPrime(sum)) {
            count++;
        }
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
