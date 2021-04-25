package leetcode.week210328;

import java.util.HashSet;
import java.util.Set;

public class LC5713 {
    public static void main(String[] args) {
        LC5713 lc = new LC5713();
        int res = lc.numDifferentIntegers("a1b0c00");
        System.out.println(res);
    }

    public int numDifferentIntegers(String word) {
        Set<String> values = new HashSet<>();

        for (int i = 0; i < word.length(); ) {
            char c = word.charAt(i);
            if (c >= '0' && c <= '9') { //is num
                StringBuilder sb = new StringBuilder();
                int zeroIndex = -1;
                boolean f = true;
                while (i < word.length() && (word.charAt(i) >= '0' && word.charAt(i) <= '9')) {
                    sb.append(word.charAt(i));

                    if (word.charAt(i) == '0' && f) {
                        zeroIndex++;
                    } else {
                        f = false;
                    }

                    i++;
                }
                if (zeroIndex == -1) {
                    values.add(sb.toString());
                } else if (zeroIndex == sb.length() - 1) {
                    values.add("0");
                } else {
                    values.add(sb.substring(zeroIndex + 1));
                }

            } else {
                i++;
            }
        }
        return values.size();
    }

}
