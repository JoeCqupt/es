package leetcode;

import java.util.HashMap;

/**
 * 优化后的滑动窗口
 * 应该是最优解法
 */
public class Solution3_3 {

    /**
     * 优化后的窗口滑动 o(n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap();
        int tempMax = Integer.MIN_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }
            tempMax = Math.max(tempMax, i - j + 1);
            map.put(s.charAt(i), i);
        }
        return tempMax;
    }

}
