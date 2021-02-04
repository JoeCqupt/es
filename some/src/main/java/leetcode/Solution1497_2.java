package leetcode;

public class Solution1497_2 {
    public static void main(String[] args) {
        Solution1497_2 solution = new Solution1497_2();
        System.out.println(
                solution.canArrange(
                        new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9},
                        5
                )
        );
    }

    public boolean canArrange(int[] arr, int k) {
        int[] res = new int[k];
        for (int i : arr) {
            res[((i % k) + k) % k]++;
        }

        for (int i = 1; i <= k / 2; i++) {
            if (res[i] != res[k - i]) {
                return false;
            }
        }
        return res[0] % 2 == 0;
    }
}
