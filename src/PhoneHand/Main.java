package PhoneHand;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int nums[][] = {{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}};
        String[] hands = {"right", "left", "right"};
        String[] results = {"LRLLLRLLRRL", "LRLLRRLLLRR", "LLRLLRLLRL"};
        for (int i = 0; i < 3; i++) {
            String result = solution.solution(nums[i], hands[i]);
            System.out.println(result + " " + results[i]);
            System.out.println("result:" + results[i].equals(result));
        }
    }
}
