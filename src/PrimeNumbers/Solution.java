package PrimeNumbers;

public class Solution {
    public static void main(String [] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5));
    }
    public int solution(int n) {
        boolean prime[] = new boolean[n + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!prime[i]) {
                answer++;
            }
        }
        return answer;
    }
}
