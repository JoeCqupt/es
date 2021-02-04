package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用一个 map 来做滑动窗口
 */
public class Solution3_2 {
    public static void main(String[] args) {
        Solution3_2 solution3_2 = new Solution3_2();
        int result = solution3_2.lengthOfLongestSubstring("bbtablud");
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int result = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            if (!window.containsKey(r)) {
                result = Math.max(right - left + 1, result);

            } else {
                // 缩小窗口
                // 重复字符的位置
                int pos = window.get(r);
                for (int i = left; i <= pos; i++) {
                    window.remove(s.charAt(i));
                }
                left = pos + 1;
            }
            window.put(r, right);
            right++;
        }
        return result;
    }
}
