package leetcode.primary.s1_arr;

public class LC189_2 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
         k = k% n;
        if(n==1){
            return;
        }
        revere(nums, 0, n - 1);
        revere(nums, 0, k - 1);
        revere(nums, k, n - 1);
    }

    private void revere(int arr[], int s, int e) {
        while (s < e) {
            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            s++;
            e--;
        }
    }
}
