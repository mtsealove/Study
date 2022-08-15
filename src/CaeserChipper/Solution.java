package CaeserChipper;

public class Solution {
    public static void main(String[] args) {
        String[] cases = {"AB", "z", "a B z"};
        int[] nums = {1, 1, 4};
        Solution solution = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(solution.solution(cases[i], nums[i]));
        }
    }

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 32) {
                sb.append(" ");
            } else {
                int newC = c + n;
                boolean ogUpper = Character.isUpperCase(c);
                boolean newUpper = Character.isUpperCase(newC);
                if (!Character.isAlphabetic(newC) || ogUpper != newUpper) {
                    newC -= 26;
                }
                sb.append(Character.toString(newC));
            }
        }
        return sb.toString();
    }
}
