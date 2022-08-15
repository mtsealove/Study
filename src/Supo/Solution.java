package Supo;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answers = {1, 2, 3, 4, 5};
        solution.solution(answers);
    }

    public int[] solution(int[] answers) {
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pick1(i + 1)) {
                score1++;
            }
            if (answers[i] == pick2(i + 1)) {
                score2++;
            }
            if (answers[i] == pick3(i + 1)) {
                score3++;
            }
        }
        if (score1 == score2 && score2 == score3) {
            return new int[]{1, 2, 3};
        }
        int max = (score1 > score2) && (score1 > score3) ? score1 : (Math.max(score3, score2));
        ArrayList<Integer> resultList = new ArrayList<>();
        if (score1 == max) {
            resultList.add(1);
        }
        if (score2 == max) {
            resultList.add(2);
        }
        if (score3 == max) {
            resultList.add(3);
        }
        int[] result = new int[resultList.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private int pick1(int nth) {
        if (nth % 5 == 0) {
            return 5;
        }
        int round = (nth / 5);
        return nth - round * 5;
    }

    private final int[] num2 = {1, 3, 4, 5};

    private int pick2(int nth) {
        int round = ((nth - 1) / 2) % 4;
        if (nth % 2 == 1) {
            return 2;
        }
        return num2[round];
    }

    private final int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    private int pick3(int nth) {
        return num3[(nth - 1) % 10];
    }
}
