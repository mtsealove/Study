package Harshed;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 10; i < 14; i++) {
            System.out.println(solution.solution(i));
        }
    }

    public boolean solution(int x) {
        String[] strArr = String.valueOf(x).split("");
        int sum = 0;
        for (String s : strArr) {
            sum += Integer.parseInt(s);
        }
        return x % sum == 0;
    }
}
