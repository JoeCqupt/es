package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个标准的 滑动窗口的 模版
 */
public class Solution76_2 {
    public String minWindow(String str, String need) {
        Map<Character, Integer> needMap = new HashMap<>();
        for (int i = 0; i < need.length(); i++) {
            char c = need.charAt(i);
            putCount(needMap, c);
        }

        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;

        int resultLeft = 0;
        int resultRight = 0;

        int valid = 0; // 表示包含上的字符的数目
        while (right < str.length()) {
            char r = str.charAt(right);
            right++;
            if (needMap.containsKey(r)) {
                int value = putCount(window, r);
                // 符号：等于
                if (value == needMap.get(r)) valid++;
            }

            //  判断能不能缩小窗口
            while (valid == needMap.size()) {
                if (resultRight == 0 || (right - left) <= (resultRight - resultLeft)) {
                    resultLeft = left;
                    resultRight = right;
                }

                char l = str.charAt(left);
                left++;
                if (needMap.containsKey(l)) {
                    int value = removeCount(window, l);
                    if (value < needMap.get(l)) {
                        valid--;
                    }
                }
            }
        }

        return resultRight == 0 ? "" : str.substring(resultLeft, resultRight);
    }

    private Integer removeCount(Map<Character, Integer> map, char c) {
        Integer value = map.get(c);
        if (value == 1) {
            map.remove(c);
            return 0;
        } else {
            map.put(c, --value);
            return value;
        }
    }


    private Integer putCount(Map<Character, Integer> map, char c) {
        Integer value = map.get(c);
        if (value != null) {
            map.put(c, ++value);
            return value;
        } else {
            map.put(c, 1);
            return 1;
        }
    }
}
