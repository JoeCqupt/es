package leetcode;


import java.util.*;

/**
 * 暴力解法 BFS
 *
 * 优化点：
 * 双向BFS
 */
public class Solution752 {

    public int openLock(String[] deadends, String target) {
        String init = "0000";
        // 初始化一下
        Set<String> deadEnds = new HashSet<>();
        for (String s : deadends) {
            deadEnds.add(s);
        }

        if (deadEnds.contains(init)) {
            return -1;
        }
        if (init.equals(target)) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(init);
        visited.add(init);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                // 尝试转动
                boolean match = tryTurn(str, visited, queue, deadEnds, target);
                if (match) {
                    return step;
                }
            }
            step++;
        }
        return -1;
    }

    private boolean tryTurn(String str, Set<String> visited, LinkedList<String> queue, Set<String> deadEnds, String target) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int value = chars[i] - 48;
            int turnUp = (value + 1) % 10 + 48;
            int turnDown = ((value + 10) - 1) % 10 + 48;

            char[] clone = chars.clone();
            clone[i] = (char) turnUp;
            String turnUpStr = String.valueOf(clone);
            clone[i] = (char) turnDown;
            String turnDownStr = String.valueOf(clone);
            if (target.equals(turnUpStr) || target.equals(turnDownStr)) {
                return true;
            }
            if (!deadEnds.contains(turnDownStr) && !visited.contains(turnDownStr)) {
                queue.add(turnDownStr);
                visited.add(turnDownStr);
            }
            if (!deadEnds.contains(turnUpStr) && !visited.contains(turnUpStr)) {
                queue.add(turnUpStr);
                visited.add(turnUpStr);
            }

        }
        return false;
    }

}
