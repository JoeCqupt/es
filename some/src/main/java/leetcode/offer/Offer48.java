package leetcode.offer;

public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 0;

        char[] chars = new char[255];

        int maxLength = 1;
        int left = 0;
        chars[s.charAt(left)]++;
        int right = 1;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (chars[c] == 1) {
                // 表示目前有重复的字符， 开始缩小窗口
                while (left < right) {
                    if (s.charAt(left) == c) {
                        left++;
                        break;
                    } else {
                        // 需要取消之前的字符的计数
                        chars[s.charAt(left)]--;
                        left++;
                    }
                }
            } else {
                chars[c] ++ ;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
