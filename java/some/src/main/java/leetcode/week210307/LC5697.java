package leetcode.week210307;

public class LC5697 {

    public static void main(String[] args) {
        LC5697 lc = new LC5697();
        boolean b = lc.checkOnesSegment("1001");
        System.out.println(b);
    }
    public boolean checkOnesSegment(String s) {
        int l = 0;
        int r = s.length()-1;
        boolean lFound = false;
        boolean rFound = false;
        while (l < r) {
            if (lFound && rFound) {
                break;
            }

            if (!lFound && s.charAt(l) == '0') {
                l++;
            } else {
                lFound = true;
            }
            if (!rFound && s.charAt(r) == '0') {
                r--;
            } else {
                rFound = true;
            }
        }

        if (l > r) return true;
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '0') return false;
        }
        return true;
    }
}
