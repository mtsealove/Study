package WiredWord;

public class Solution {
    public static void main(String[] args) {
        String str = "try hello world";
        Solution solution = new Solution();
        System.out.println(solution.solution(str).equals("TrY HeLlO WoRlD"));
    }

    public String solution(String s) {
        String[] arr = s.split(" ");

        String[] result = new String[arr.length];
        int j = 0;
        for (String str : arr) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0) {
                    sb.append(Character.toString(str.charAt(i) - 32));
                } else {
                    sb.append(str.charAt(i));
                }
            }
            result[j] = sb.toString();
            j++;
        }
        String r = String.join(" ", result);
        if(r.length() != s.length()) {
            r = r + " ";
        }
        return r;
    }
}
