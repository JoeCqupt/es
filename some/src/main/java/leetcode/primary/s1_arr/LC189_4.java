package leetcode.primary.s1_arr;

public class LC189_4 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int next = (i + k) % n;
            int move = nums[i];
            while (next != i) {
                int temp = nums[next];
                nums[next] = move;
                move = temp;
                next = (next + k) % n;
                count++;
                if (count == n) {
                    return;
                }
            }
            //到达一个循环
            nums[next] = move;
            count++;
            if (count == n) {
                return;
            }
        }
    }
}
