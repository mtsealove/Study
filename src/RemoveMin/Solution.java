package RemoveMin;


public class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{1};
        }
        int[] answer = new int[arr.length - 1];
        int min = arr[0];
        for (int n : arr) {
            if (n < min) {
                min = n;
            }
        }
        int i = 0;
        for (int n : arr) {
            if (n != min) {
                answer[i] = n;
                i++;
            }
        }
        return answer;
    }
}
