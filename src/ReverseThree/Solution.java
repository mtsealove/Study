package ReverseThree;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(45));
    }

    // 3진수 변환 후 역으로 변환하여 다시 10진수로 변환
    public int solution(int n) {
        int answer = 0;
        String threeNum = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder();
        for (int i = threeNum.length() - 1; i >= 0; i--) {
            sb.append(threeNum.charAt(i));
        }
        String threeReverse = sb.toString();
        for (int i = 0; i < threeReverse.length(); i++) {
            int point = threeReverse.length() - 1 - i;
            int num = Integer.parseInt(String.valueOf(threeReverse.charAt(i)));
            answer += num * Math.pow(3, point);
        }
        return answer;
    }
}
