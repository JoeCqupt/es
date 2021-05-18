package leetcode.week210321;

public class Solution5711 {

    public static void main(String[] args) {
        Solution5711 s = new Solution5711();
        int i = s.maxValue(1,
                0,
                780055968);
        System.out.println(i);
    }

    // 1 <= n <= maxSum <= 109
    // 0 <= index < n
    public int maxValue(int n, int index, int maxSum) {
        int res = 1;
        int extend = 1;
        int left = index - 1;
        int right = index + 1;
        maxSum -= n;
        while (maxSum >= extend) {
            res++;
            maxSum -= extend;

            if (left < 0 && right >= n) {
                res += maxSum / n;
                break;
            }

            extend = 0;
            if (left >= 0) {
                extend += index - left;
                left--;
            } else {
                extend += index - 0;
            }
            if (right < n) {
                extend += right - index;
                right++;
            } else {
                extend += (n - 1) - index;
            }
            extend++;
        }
        return res;
    }

}
