package leetcode.week210314;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC5703 {

    public static void main(String[] args) {
        LC5703 lc = new LC5703();

        double v = lc.maxAverageRatio(
                new int[][]{{1, 2}, {3, 5}, {2, 2}},
                2
        );
        System.out.println(v);
    }

    static class Node {
        int index;
        double ratio;

        public Node(int index, double ratio) {
            this.index = index;
            this.ratio = ratio;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.ratio - o2.ratio < 0 ? 1 : -1;
            }
        });


        for (int j = 0; j < n; j++) {
            int[] clazz = classes[j];
            //计算增长率
            double ratio = (((double) clazz[0] + 1) / ((double) clazz[1] + 1)) - ((double) clazz[0] / (double) clazz[1]);
            queue.add(new Node(j, ratio));
        }

        for (int i = 0; i < extraStudents; i++) {
            Node node = queue.poll();
            int[] aClass = classes[node.index];
            aClass[0]++;
            aClass[1]++;
            double ratio = (((double) aClass[0] + 1) / ((double) aClass[1] + 1)) - ((double) aClass[0] / (double) aClass[1]);
            queue.add(new Node(node.index, ratio));
        }


        double totalRatio = 0.0;
        for (int j = 0; j < n; j++) {
            totalRatio += (double) classes[j][0] / classes[j][1];
        }

        return totalRatio / n;
    }

}
