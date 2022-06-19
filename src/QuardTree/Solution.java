package QuardTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    // 쿼드 트리 압축
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 배열의 개수는 4배수로 주어짐
        int[][][] arrs = {
                {
                        {1, 1, 0, 0},
                        {1, 0, 0, 0},
                        {1, 0, 0, 1},
                        {1, 1, 1, 1}
                },
                {
                        {1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1},
                        {0, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1}}
        };
        for (int[][] arr : arrs) {
            System.out.println(Arrays.toString(solution.solution(arr)));
        }
    }

    public int[] solution(int[][] arr) {
        int[] answer = {};
        QuadTree quadTree = new QuadTree();

        for (int i = 0; i < arr.length; i += 2) {
            for (int j = 0; j < arr.length; j += 2) {
                int x1 = i, x2 = i + 1, y1 = j, y2 = j + 1;
                int[] values = {
                        arr[y1][x1],
                        arr[y1][x2],
                        arr[y2][x1],
                        arr[y2][x2]
                };
                QuadTree tree = new QuadTree(values);
                quadTree.children.add(tree);
//                System.out.println(tree.toString());
            }
        }
        quadTree.compress();
        int one = quadTree.getOne();
        int zero = quadTree.getZero();

        System.out.println(quadTree.toString());
        System.out.println("depth: " + quadTree.getDepth());
        System.out.println("one: " + one + " zero: " + zero);
        return answer;
    }

    class QuadTree {
        ArrayList<QuadTree> children;
        int[] values = null;
        int value = -1;

        public QuadTree() {
            this.children = new ArrayList<>();
        }

        // 값을 매개로 생성
        public QuadTree(int[] values) {
            this.values = values;
            compress();
        }

        public int getDepth() {
            if (this.children == null) {
                return 0;
            }
            int maxDepth = 0;
            for (QuadTree c : children) {
                if (c.getDepth() > maxDepth) {
                    maxDepth = c.getDepth();
                }
            }
            return maxDepth + 1;
        }


        public void compress() {
            // 값들이 여러개 존재할 때
            if (this.values != null) {
                boolean same = true;
                for (int i = 0; i < values.length; i++) {
                    for (int j = 0; j < values.length; j++) {
                        if (i != j && values[i] != values[j]) {
                            same = false;
                            break;
                        }
                    }
                }
                if (same) { // 모든 값이 같을 때 하나의 값으로 치환
                    this.value = values[0];
                    this.values = null;
                }
            }
            if (this.children != null) {
                boolean same = true;
                if (this.children.size() % 16 == 0) { // 자식이 8개 이상일 때 분할
                    ArrayList<QuadTree> newChildren = new ArrayList<>();
                    for (int i = 0; i < this.children.size(); i++) {
                        if (i % 4 == 0) {
                            QuadTree child = new QuadTree();
                            newChildren.add(child);
                        }
                        newChildren.get(newChildren.size() - 1).children.add(this.children.get(i));
                    }
                    this.children = newChildren;
                }
                for (QuadTree child : children) {
                    child.compress();
                }
                for (int i = 0; i < children.size(); i++) {
                    for (int j = 0; j < children.size(); j++) {
                        if ((i != j &&
                                children.get(i).value != children.get(j).value)
                                || children.get(i).values != null) {
                            same = false;
                        }
                    }
                }
                if (same) {
                    this.value = children.get(0).value;
                    this.values = null;
                    this.children = null;
                }
            }
        }

        public int getOne() {
            if (this.children != null) {
                int sum = 0;
                for (QuadTree c : children) {
                    sum += c.getOne();
                }
                return sum;
            }
            if (this.values != null) {
                int sum = 0;
                for (int n : values) {
                    if (n == 1) {
                        sum++;
                    }
                }
                return sum;
            }
            if (this.value == 1) {
                return 1;
            }
            return 0;
        }

        public int getZero() {
            if (this.children != null) {
                int sum = 0;
                for (QuadTree c : children) {
                    sum += c.getZero();
                }
                return sum;
            }
            if (this.values != null) {
                int sum = 0;
                for (int n : values) {
                    if (n == 0) {
                        sum++;
                    }
                }
                return sum;
            }
            if (this.value == 0) {
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            if (this.values != null) {
                return "values: " + Arrays.toString(this.values);
            }
            if (this.value != -1) {
                return "value: " + this.value;
            }
            if (this.children != null) {
                StringBuilder sb = new StringBuilder();
                for (QuadTree c : this.children) {
                    sb.append(c.toString()).append("\n");
                }
                return sb.toString();
            }
            return super.toString();
        }
    }
}
