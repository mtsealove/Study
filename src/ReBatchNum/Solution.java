package ReBatchNum;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public long solution(long n) {
        long answer = 0;
        String[] strArr = String.valueOf(n).split("");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : strArr) {
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i) * Math.pow(10, i);
        }
        return answer;
    }
}
