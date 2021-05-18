package leetcode.primary.s2_str;

public class LC8 {

    public int myAtoi(String s) {
        int result = 0;
        int flag = 1;
        boolean enflag = true;
        boolean enSkip = true;
        for (char c : s.toCharArray()) {
            if (enSkip && c == ' ') {
                continue;
            } else if (enflag && c == '-') {
                flag = -1;
                enflag = false;
                enSkip = false;
            } else if (enflag && c == '+') {
                flag = 1;
                enflag = false;
                enSkip = false;
            } else {
                if (!isNum(c)) {
                    break;
                }
                enflag = false;
                enSkip = false;
                int value = (c - '0') * flag;

                if (flag == 1) {
                    if (Integer.MAX_VALUE / 10 < result ||
                            (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < value)) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (Integer.MIN_VALUE / 10 > result ||
                            (Integer.MIN_VALUE / 10 == result && Integer.MIN_VALUE % 10 > value)) {
                        return Integer.MIN_VALUE;
                    }
                }

                result = result * 10 + value;
            }

        }
        return result;
    }

    private boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }
}
