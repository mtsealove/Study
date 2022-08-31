package Crain;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1},
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        Solution solution = new Solution();
        System.out.println(solution.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int f = fetch(board, move - 1);
            if(f != 0) {
                stack.add(f);
                if(crash(stack)) {
                    answer +=2;
                }
            }
        }
        return answer;
    }

    private int fetch(int[][] board, int move) {
        for(int i=0; i<board.length; i++) {
            if(board[i][move]!=0) {
                int num =board[i][move];
                board[i][move] = 0;
                return num;
            }
        }
        return 0;
    }

    private boolean crash(Stack<Integer> stack) {
        if(stack.size() >=2 && stack.get(stack.size()-1).equals(stack.get(stack.size() - 2))) {
            stack.pop();
            stack.pop();
            return true;
        }
        return false;
    }
}
