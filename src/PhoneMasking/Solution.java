package PhoneMasking;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cases = {"01033334444", "027778888"};
        for(String s: cases) {
            System.out.println(solution.solution(s));
        }

    }

    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<phone_number.length() -4; i++) {
            sb.append("*");
        }
        String visible = phone_number.substring(phone_number.length() - 4,phone_number.length());
        return sb.toString() + visible;
    }
}
