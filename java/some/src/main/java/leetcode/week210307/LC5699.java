package leetcode.week210307;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC5699 {

    public static void main(String[] args) {
        LC5699 lc = new LC5699();
        int i = lc.countRestrictedPaths(
                7,
                new int[][]{{1, 3, 1}, {4, 1, 2}, {7, 3, 4}, {2, 5, 3}, {5, 6, 1}, {6, 7, 2}, {7, 5, 3}, {2, 6, 4}}
        );
        System.out.println(i);
    }

    static class Node implements Comparable<Node> {
        int v;
        int value;

        public Node(int v, int value) {
            this.v = v;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }

    int DIV = 1000000007;

    public int countRestrictedPaths(int n, int[][] edges) {
        boolean[] visited = new boolean[n + 1];
        Map<Integer, Integer>[] vks = new Map[n + 1];
        for (int[] edge : edges) {
            if (vks[edge[0]] == null) vks[edge[0]] = new HashMap<>();
            vks[edge[0]].put(edge[1], edge[2]);

            if (vks[edge[1]] == null) vks[edge[1]] = new HashMap<>();
            vks[edge[1]].put(edge[0], edge[2]);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(n, 0));

        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[n] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int v = poll.v;
            if (visited[v] == true) {
                continue;
            }
            visited[v] = true;
            for (Map.Entry<Integer, Integer> entry : vks[v].entrySet()) {
                if (visited[entry.getKey()] == false) {
                    if (res[v] + entry.getValue() < res[entry.getKey()]) {
                        res[entry.getKey()] = res[v] + entry.getValue();
                        queue.add(new Node(entry.getKey(), res[v] + entry.getValue()));
                    }
                }
            }
        }

        // 开始记忆化dfs搜索
        Long[] countMap = new Long[n + 1];
        return (int) (dfs(1, vks, res, countMap, n) % DIV);
    }

    private long dfs(int i, Map<Integer, Integer>[] vks, int[] res, Long[] countMap, int n) {
        if (i == n) {
            return 1;
        }
        if (countMap[i] != null) {
            return countMap[i];
        }
        long value = 0L;
        for (int key : vks[i].keySet()) {
            if (res[i] > res[key]) {
                value += (dfs(key, vks, res, countMap, n) % DIV);
            }
        }
        countMap[i] = value;
        return value;
    }
}
