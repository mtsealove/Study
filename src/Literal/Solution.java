package Literal;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"a234", "1234", "3e10"};
        Solution solution = new Solution();
        for(String s: strs) {
            System.out.println(solution.solution(s));
        }
    }

    public boolean solution(String s) {
        boolean firstAlpha = Character.isAlphabetic(s.charAt(0));
        if(s.length() != 4 && s.length() != 6) {
            return false;
        }
        for(int i=1; i<s.length(); i++) {
            if(Character.isAlphabetic(s.charAt(i)) != firstAlpha) {
                return false;
            }
        }
        return true;
    }
}
