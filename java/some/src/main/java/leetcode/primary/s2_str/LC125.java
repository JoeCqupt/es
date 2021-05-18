package leetcode.primary.s2_str;

public class LC125 {
    public static void main(String[] args) {
        LC125 soulution = new LC125();
        System.out.println(
                soulution.isPalindrome("0P")
        );
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            char c1 = s.charAt(l);
            if (!isRight(c1)) {
                l++;
                continue;
            }

            char c2 = s.charAt(r);
            if (!isRight(c2)) {
                r--;
                continue;
            }
            if (c1 != c2) {
                if (isNum(c1) || isNum(c2))
                    return false;

                if (Math.abs(c1 - c2) != Math.abs('A' - 'a'))
                    return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isRight(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || isNum(c);
    }

    private boolean isNum(char c) {
        return ('0' <= c && c <= '9');
    }
}
