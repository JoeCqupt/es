package leetcode.array;

public class FindDuplicate {

    /**
     * 使用快慢指针思想
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];

            if (slow == fast) {
                slow = 0;
                while (nums[slow] != nums[fast]) {
                    slow = nums[slow];
                    fast = nums[fast];
                }

                return nums[slow];
            }
        }
    }

    /**
     * 使用 遍历+递减 思想
     * <p>
     * 不能使用累加，因为累加有溢出的风险
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = nums[i];
            if (index < 0) {
                index += len;
            }

            if (nums[index] < 0) {
                return index;
            } else {
                nums[index] -= len;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int result = new FindDuplicate().findDuplicate2(new int[]{1, 3, 4, 2, 2});
        System.out.println(result);
    }


    /***
     * 1,3,4,2,2
     *
     * fast:3->4->4->4->4->4
     *
     * slow:1->3->2->4->2->4
     */
}