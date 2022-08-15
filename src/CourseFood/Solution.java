package CourseFood;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] cases = {{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                {"XYZ", "XWY", "WXA"}};
        int[][] counts = {
                {2, 3, 4},
                {2, 3, 5},
                {2, 3, 4}
        };
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(solution.solution(cases[i], counts[i])));
        }
    }

    private ArrayList<ArrayList<Character>> comb = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<Character> menus = new ArrayList<>();
        // 존재하는 메뉴 모두 검색
        for (String order : orders) {
            for (int i = 0; i < order.length(); i++) {
                Character c = order.charAt(i);
                if (!menus.contains(c)) {
                    menus.add(c);
                }
            }
        }
        char[] menuArr = new char[menus.size()];
        for (int i = 0; i < menus.size(); i++) {
            comb = new ArrayList<>();
            menuArr[i] = menus.get(i);
        }
        // 존재할 개수 만큼 찾기
        for (int c : course) {
            boolean[] visited = new boolean[menus.size()];
            combination(menuArr, visited, 0, menus.size(), c);
            for (ArrayList<Character> cb : comb) {
                System.out.println(cb);
            }
        }
        System.out.println("");
        return answer;
    }

    private void combination(char[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private void print(char[] arr, boolean[] visited, int n) {
        ArrayList<Character> result = new ArrayList();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
//                System.out.print(arr[i] + " ");
                result.add(arr[i]);
            }
        }
        comb.add(result);
    }
}
