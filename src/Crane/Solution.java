package Crane;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    ArrayList<Integer> stack = new ArrayList();
    int count = 0;

    public int solution(int[][] board, int[] moves) {
        for (int move : moves) {
            int hr = 0;
            while (hr < board.length - 1 && board[hr][move - 1] == 0) {
                hr += 1;
            }
//            System.out.println("move: " + move + ", depth: " + hr);
            addToStack(board[hr][move - 1]);
            board[hr][move - 1] = 0;
        }
//        System.out.println(this.stack.toString());
        return this.count;
    }

    public void addToStack(int num) {
//        System.out.println(this.stack.toString() + ", "+num);
        if (num == 0) {
            return;
        }

        if (stack.size() == 0) {
            stack.add(num);
        } else {
//            System.out.println("addToStack");
            if (stack.get(stack.size() - 1) == num) {
                stack.remove(stack.size() - 1);
                this.count++;
            } else {
                stack.add(num);
            }
        }
    }
}
