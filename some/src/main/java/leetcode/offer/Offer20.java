package leetcode.offer;

public class Offer20 {
    public static void main(String[] args) {
        Offer20 o = new Offer20();
        boolean res = o.isNumber(".1");
        System.out.println(res);
    }
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        isNumber(s.trim());
        boolean signal = true; // 是否可以出现符号
        boolean point = true;
        boolean E = false;
        boolean valid = false;

        boolean noPoint = false;
        boolean noE = false;
        boolean digitAppear = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isSignal(c)) {
                if(!signal) return false;
                signal = false;
                valid = false;
                E = false;
                point = true;
                continue;
            }
            if (isDigit(c)) {
                point = true;
                E = true;
                valid = true;
                signal = false;
                digitAppear = true;
                continue;
            }
            if (isPoint(c)) {
                if (noPoint) return false;
                if (!point) return false;
                point = false;
                valid = digitAppear?true:false;
                E = false;
                signal=false;
                noPoint = true;
                continue;
            }
            if (isE(c)) {
                if (noE) return false;
                if (!E) return false;
                signal = true;
                point = false;
                valid = false;
                E = false;
                noE = true;
                noPoint = true;
            }
        }
        return valid;
    }

    private boolean isSignal(char c) {
        return c == '+' || c == '-';
    }

    private boolean isPoint(char c) {
        return c == '.';
    }

    private boolean isE(char c) {
        return c == 'E' || c == 'e';
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
