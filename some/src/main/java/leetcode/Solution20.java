package leetcode;

import java.util.ArrayDeque;

public class Solution20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>(s.length());
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (stack.size() == 0) {
                stack.addLast(c);
            } else {
                char c1 = stack.removeLast();
                boolean r = isMatch(c, c1);
                if (!r) {
                    stack.addLast(c1);
                    stack.addLast(c);
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    private boolean isMatch(char c, char c1) {
        if (c1 == '(' && c == ')') {
            return true;
        }
        if (c1 == '{' && c == '}') {
            return true;
        }
        if (c1 == '[' && c == ']') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution20().isValid("()");
    }
}