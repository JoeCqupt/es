package leetcode.week201206;

public class Solution5620_2 {

    public static void main(String[] args) {
        Solution5620_2 s = new Solution5620_2();
        s.concatenatedBinary(0);
    }
    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        String s = sb.toString();


        System.out.println(Integer.toBinaryString(100000));

        //  todo @jiangyuan
        return 0;
    }
}
