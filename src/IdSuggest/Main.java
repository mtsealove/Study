package IdSuggest;

public class Main {
    public static void main(String[] args) {
        String[] cases = {
                "...!@BaT#*..y.abcdefghijklm",
                "z-+.^.",
                "=.=",
                "123_.def",
                "abcdefghijklmn.p"};
        String[] results = {
                "bat.y.abcdefghi",
                "z--",
                "aaa", "123_.def",
                "abcdefghijklmn"};

        boolean perfect = true;
        Solution solution = new Solution();
        for (int i = 0; i<5; i++) {
            System.out.println(cases[i] + " : "+results[i]);
            String convert = solution.solution(cases[i]);
            boolean correct =results[i].equals(convert);
            System.out.println(convert + ": " + correct);
            if(!correct) {
                perfect = false;
            }
        }
        System.out.println("perfect: "+ perfect);
    }
}
