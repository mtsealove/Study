package DartScore;


public class Solution {
    public static void main(String[] args) {
        String[] cases = {
                "1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*", "10S10S10S"
        };
        int[] results = {37, 9, 3, 23, 5, -4, 59, 30};
        Solution solution = new Solution();
        for (int i = 0; i < cases.length; i++) {
            int r = solution.solution(cases[i]);
            System.out.println(r + ": " + (r == results[i]));
        }
    }

    public int solution(String dartResult) {
        int[] breakPoints = new int[2];
        int breakIdx = 0;
        dartResult = dartResult.replace("10", "m");
        // 문자열 분해
        for (int i = 1; i < dartResult.length(); i++) {
            if (Character.isDigit(dartResult.charAt(i)) || dartResult.charAt(i) == 'm') {
                breakPoints[breakIdx] = i;
                breakIdx++;
                if (breakIdx == 2) {
                    break;
                }
            }
        }

        String point1 = dartResult.substring(0, breakPoints[0]);
        String point2 = dartResult.substring(breakPoints[0], breakPoints[1]);
        String point3 = dartResult.substring(breakPoints[1]);
        String[] points = {point1, point2, point3};
        int result = 0;
        int[] nums = {0, 0, 0};
        int idx = 0;

        for (String point : points) {
            int num = 0;
            int pow = 1;
            String option = "";
//            point = point.replace("10", "m");
            for (int i = 0; i < point.length(); i++) {
                char c = point.charAt(i);
                switch (i) {
                    case 0:
                        if (c == 'm') {
                            num = 10;
                        } else {
                            num = Character.getNumericValue(c);
                        }
                        break;
                    case 1:
                        pow = switch (c) {
                            case 'S' -> 1;
                            case 'D' -> 2;
                            default -> 3;
                        };
                    default:
                        if (c == '#') {
                            option = "arch";
                        } else if (c == '*') {
                            option = "star";
                        }
                }
            }
            if (option.equals("arch")) {
//                result *= -1;
//                result -= Math.pow(num, pow);
                nums[idx] = (int) Math.pow(num, pow) * -1;
            } else if (option.equals("star")) {
                if (idx > 0) {
                    nums[idx - 1] *= 2;
                }
                nums[idx] = (int) (Math.pow(num, pow) * 2);
            } else {
                nums[idx] = (int) Math.pow(num, pow);
            }
            idx++;
        }
        for (int n : nums) {
            result += n;
        }
//        System.out.println(String.format("%s %s %s", point1, point2, point3));
//        System.out.println(String.format("%d %d %d", nums[0], nums[1], nums[2]));
        return result;
    }
}
