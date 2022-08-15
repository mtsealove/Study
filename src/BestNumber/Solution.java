package BestNumber;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        String[] nums = {"1924", "1231234", "4177252841"};
        int[] ks = {2, 3, 4};
        Solution solution = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(solution.solution(nums[i], ks[i]));
        }
    }

    private ArrayList<ArrayList<Integer>> cases;

    public String solution(String number, int k) {
        cases = new ArrayList<>();
        String[] sp = number.split("");
        int[] nums = new int[sp.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(sp[i]);
        }
        int[] arr = new int[number.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        boolean[] visited = new boolean[arr.length];
        comb(arr, visited, 0, k);
        ArrayList<Integer> calcs = new ArrayList<>();
        for (ArrayList<Integer> list : cases) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                if (!list.contains(i)) {
                    sb.append(nums[i]);
                }
            }
            calcs.add(Integer.parseInt(sb.toString()));
        }
        Collections.sort(calcs);
        Collections.reverse(calcs);
        return calcs.get(0).toString();
    }

    void comb(int[] arr, boolean[] visited, int depth, int r) {
        if (r == 0) {
            print(arr, visited);
            return;
        }
        if (depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            comb(arr, visited, depth + 1, r - 1);
            visited[depth] = false;
            comb(arr, visited, depth + 1, r);
        }
    }

    void print(int[] arr, boolean[] visited) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == true)
                list.add(arr[i]);
        }
        cases.add(list);
    }
}
