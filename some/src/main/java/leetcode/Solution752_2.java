package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 双向BFS 优化
 *
 * 同时每次使用小一点的队列进行尝试，内存占用量会小一些
 */
public class Solution752_2 {

    public static void main(String[] args) {
        Solution752_2 solution752_2 = new Solution752_2();
        solution752_2.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888");
    }

    public int openLock(String[] deadends, String target) {
        String init = "0000";

        // 初始化一下
        Set<String> deadEnds = new HashSet<>();
        for (String s : deadends) {
            deadEnds.add(s);
        }

        if (deadEnds.contains(init) || deadEnds.contains(target)) {
            return -1;
        }
        if (init.equals(target)) {
            return 0;
        }

        Set<String> initVisited = new HashSet<>();
        LinkedList<String> initQueue = new LinkedList<>();
        initQueue.add(init);
        initVisited.add(init);

        Set<String> targetVisited = new HashSet<>();
        LinkedList<String> targetQueue = new LinkedList<>();
        targetQueue.add(target);
        targetVisited.add(target);


        int step = 1;
        while (!initQueue.isEmpty() && !targetQueue.isEmpty()) {
            int initSize = initQueue.size();
            int targetSize = targetQueue.size();
            if (initSize <= targetSize ) {
                for (int i = 0; i < initSize; i++) {
                    String str = initQueue.poll();
                    // 尝试转动
                    boolean match = tryTurn(str, initVisited, initQueue, deadEnds, targetVisited);
                    if (match) {
                        return step;
                    }
                }
            } else {
                for (int j = 0; j < targetSize; j++) {
                    String str = targetQueue.poll();
                    // 尝试转动
                    boolean match = tryTurn(str, targetVisited, targetQueue, deadEnds, initVisited);
                    if (match) {
                        return step;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private boolean tryTurn(String str, Set<String> visited, LinkedList<String> queue, Set<String> deadEnds, Set<String> others) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 48 是 '0' 的ascii值
            int value = chars[i] - 48;
            int turnUp = (value + 1) % 10 + 48;
            int turnDown = ((value + 10) - 1) % 10 + 48;

            char[] clone = chars.clone();
            clone[i] = (char) turnUp;
            String turnUpStr = String.valueOf(clone);
            clone[i] = (char) turnDown;
            String turnDownStr = String.valueOf(clone);


            if (others.contains(turnUpStr) || others.contains(turnDownStr)) {
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
