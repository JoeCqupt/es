package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口 fuck fuck fuck!!!
 * <p>
 * 运行效果很垃圾
 */
public class Solution76 {

    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        String s = solution76.minWindow("ADOBECODEBANC",
                "ABC"
        );
        System.out.println(s);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        // 初始化t
        for (char c : t.toCharArray()) {
            putCount(tMap, c);
        }

        int left = 0;
        int right = 0;

        int resultLeft = 0;
        int resultRight = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            putCount(window, r);
            while (canShrink(window, tMap)) {
                if (resultRight == 0) {
                    resultLeft = left;
                    resultRight = right;
                } else if ((right - left) <= (resultRight - resultLeft)) {
                    resultLeft = left;
                    resultRight = right;
                }


                char l = s.charAt(left);
                removeCount(window, l);
                if (canShrink(window, tMap)) {
                    left++;
                } else {
                    putCount(window, l);
                    break;
                }
            }
        }
        return resultRight == 0 ? "" : s.substring(resultLeft, resultRight);
    }

    private boolean canShrink(Map<Character, Integer> window, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Integer windowValue = window.get(entry.getKey());
            if (windowValue == null || windowValue < entry.getValue()) {
                return false;
            }

        }
        return true;
    }


    private void removeCount(Map<Character, Integer> map, char c) {
        Integer value = map.get(c);
        if (value == 1) {
            map.remove(c);
        } else {
            map.put(c, --value);
        }
    }

    private void putCount(Map<Character, Integer> map, char c) {
        Integer value = map.get(c);
        if (value != null) {
            map.put(c, ++value);
        } else {
            map.put(c, 1);
        }
    }
}
