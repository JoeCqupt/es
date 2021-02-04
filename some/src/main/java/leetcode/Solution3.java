package leetcode;

/**
 * 使用滑动窗口
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();

        System.out.println(solution3.lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        int[] charCount = new int[255];

        int result = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            int value = charCount[r]++;
            right++;
            if (value == 0) {
                result = Math.max((right - left), result);
            } else {
                while (hasDe(charCount)) {
                    char l = s.charAt(left);
                    //  优化
                    int value2 = charCount[l]--;
                    left++;
                    if (value2 == 2) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    private boolean hasDe(int[] charCount) {
        for (int i : charCount) {
            if (i > 1) {
                return true;
            }
        }
        return false;
    }

}
