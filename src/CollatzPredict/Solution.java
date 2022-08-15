package CollatzPredict;

public class Solution {
    /*
    1-1. 입력된 수가 짝수라면 2로 나눕니다.
1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
     */
    public static void main(String[] args) {
        int[] cases = {6, 16, 626331};
        Solution solution = new Solution();
        for (int num : cases) {
            System.out.println(solution.solution(num));
        }
    }

    public int solution(int num) {
        int answer = 0;
        long n = num;
        while (n != 1 && answer < 500) {
            answer++;
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n *= 3;
                n++;
            }
        }
        if (answer == 500) {
            return -1;
        }
        return answer;
    }
}
