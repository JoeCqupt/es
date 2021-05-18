package leetcode.week201122;

public class Solution5606 {

    public static void main(String[] args) {
        Solution5606 solution5606 = new Solution5606();
        solution5606.getSmallestString(5
                , 73);
    }

    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        genString(n, k, result);

        return String.valueOf(result);
    }


    private int genString(int n, int k, char[] result) {
        if (n == 1) {
            if (k >= 26) {
                result[result.length - n] = 'z';
                return k - 26;
            } else {
                result[result.length - n] = (char) (k + 'a' - 1);
                return 0;
            }
        }

        int value = genString(n - 1, k - 1, result);
        if (value >= 25) {
            result[result.length - n] = 'z';
            return value - 25;
        } else {
            result[result.length - n] = (char) ('a' + value);
            return 0;
        }
    }
}
