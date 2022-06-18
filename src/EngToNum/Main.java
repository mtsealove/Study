package EngToNum;

public class Main {
    public static void main(String[] ars) {
        String[] t ={"one4seveneight", "23four5six7", "2three45sixseven", "123"};
        int [] results ={1478, 234567, 234567, 123};
        Solution solution = new Solution();
        for(int i=0; i< t.length; i++) {
            System.out.println(solution.solution(t[i]));
        }
    }
}
