package leetcode.primary.s2_str;

public class LC7 {

    public static void main(String[] args) {
        LC7 solution = new LC7();
        int reverse = solution.reverse(123);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int div;
        int sub;

        int[] arr = new int[32];
        int i = 0;
        while ((div = x % 10) != 0 | (sub = x / 10) != 0) {
            arr[i++] = div;
            x = sub;
        }

        int result = 0;
        for (int j = 0; j < i; j++) {
            int value = arr[j];
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < value))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && Integer.MIN_VALUE % 10 > value))
                return 0;
            result = result * 10 + value;
        }

        return result;
    }
}
