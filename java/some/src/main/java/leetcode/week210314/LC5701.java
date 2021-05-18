package leetcode.week210314;

public class LC5701 {
    public static void main(String[] args) {
        LC5701 lc = new LC5701();
        lc.areAlmostEqual("bank",
                "kanb");
    }
    public boolean areAlmostEqual(String s1, String s2) {
        int p1 = -1;
        int p2 = -1;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (diff == 0 && s1.charAt(i) != s2.charAt(i)) {
                diff++;
                p1 = i;
            }
            else if (diff == 1 && s1.charAt(i) != s2.charAt(i)) {
                diff++;
                p2 = i;
            }else  if (diff == 2 && s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        if (diff == 0) {
            return true;
        }
        if (diff == 1) {
            return false;
        }
        if (s1.charAt(p1) == s2.charAt(p2) &&
                s1.charAt(p2) == s2.charAt(p1)) {
            return true;
        }
        return false;
    }
}
