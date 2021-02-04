package leetcode.week201206;

import java.math.BigDecimal;

/**
 * todo 超时
 */
public class Solution5620 {

    public static void main(String[] args) {
        Solution5620 solution5620 = new Solution5620();
        int i = solution5620.concatenatedBinary(12);
        System.out.println(i);
    }

    public int concatenatedBinary(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        String s = sb.toString();
        BigDecimal b = new BigDecimal(0);
        BigDecimal temp = new BigDecimal(1);
        BigDecimal two = new BigDecimal(2);
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = s.charAt(i) - '0';
            BigDecimal v = new BigDecimal(value);
            BigDecimal multiply = v.multiply(temp);
            b = b.add(multiply);
            temp = temp.multiply(two);
        }


        int value = (int) (Math.pow(10, 9) + 7);
        BigDecimal bigDecimal = new BigDecimal(value);
        return b.divideAndRemainder(bigDecimal)[1].intValue();
    }

}
