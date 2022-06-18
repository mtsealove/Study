package UserReport;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] id_list = {
                {"muzi", "frodo", "apeach", "neo"},
                {"con", "ryan"}};
        String[][] report = {{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                {"ryan con", "ryan con", "ryan con", "ryan con"}};
        int [] k = {2, 3};
        int[][] result = {{2, 1, 1, 0}, {0, 0}};
        Solution solution = new Solution();
        for (int i = 0; i < 2; i++) {
            System.out.println("result: " + Arrays.toString(solution.solution(id_list[i], report[i], k[i])));
        }
    }
}
