package leetcode.week201227;

public class Solution5637 {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isEChar(s.charAt(i)) && i < mid) {
                left++;
            } else if (isEChar(s.charAt(i))) {
                right++;
            }
        }
        return left == right;
    }

    private boolean isEChar(char c) {
        if (
                c == 'a' ||
                        c == 'e' ||
                        c == 'i' ||
                        c == 'o' ||
                        c == 'u' ||
                        c == 'A' ||
                        c == 'E' ||
                        c == 'I' ||
                        c == 'O' ||
                        c == 'U'
        )
            return true;

        return false;
    }
}
