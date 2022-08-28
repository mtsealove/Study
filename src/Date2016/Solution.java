package Date2016;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(10, 11);
    }
    public String solution(int a, int b) {
        String answer = "";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat eFormat = new SimpleDateFormat("E");

        try {
            Date date = format.parse("2016-" + a + "-" + b);
            //SUN,MON,TUE,WED,THU,FRI,SAT
            switch (eFormat.format(date)) {
                case "일" -> answer = "SUN";
                case "월" -> answer = "MON";
                case "화" -> answer = "TUE";
                case "수" -> answer = "WED";
                case "목" -> answer = "THU";
                case "금" -> answer = "FRI";
                case "토" -> answer = "SAT";
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return answer;
    }
}
