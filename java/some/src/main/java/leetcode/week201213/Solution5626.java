package leetcode.week201213;

public class Solution5626 {

    public static void main(String[] args) {
        Solution5626 solution5626 = new Solution5626();
        int i = solution5626.minPartitions("27346209830709182346");
        System.out.println(i);
    }

    public int minPartitions(String n) {
        int max =0;
        for(int i = 0 ;i <n.length(); i++){
           int value =  n.charAt(i) - '0';
           max = Math.max(value, max);
        }
        return max;
    }

}
