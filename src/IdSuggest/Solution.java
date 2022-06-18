package IdSuggest;

public class Solution {
    String pattern = "^[a-z0-9]+[-_.]*+[a-z0-9]+$";

    public String solution(String new_id) {
        boolean error = new_id.length() < 3 || new_id.length() > 15;
        if (!new_id.matches(pattern)) {
            error = true;
        }
        if (error) {
            return suggest(new_id);
        }
        return new_id;
    }

    private String suggest(String newID) {
        String result = newID;
        // 1 단계
        result = result.toLowerCase();
        // 2단계
        String replacePattern = "[^a-z\\d\\-_.]*";
        result = result.replaceAll(replacePattern, "");
        // 3 단계
        result = result.replaceAll("\\.{2,}", ".");
        // 4 단계
        result = result.replaceAll("^[.]|[.]$", "");
        // 5 단계
        if(result.length() ==0) {
            result = "a";
        }
        // 6 단계
        if(result.length()>=16) {
            result = result.substring(0, 15);
            result = result.replaceAll("^[.]|[.]$", "");
        }
        // 7 단계
        if(result.length() <=2){
            char lastword = result.charAt(result.length() - 1);
            for(int i=0; i<4 -result.length(); i++) {
                result += lastword;
            }
        }
        return result;
    }
}
