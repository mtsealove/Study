package StringAsc;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("Zbcdefg"));
    }

    public String solution(String s) {
        String[] sp = s.split("");
        ArrayList<String> list = new ArrayList();
        for(String str: sp) {
            list.add(str);
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(list.size() - i - 1));
        }
        return sb.toString();
    }
}
