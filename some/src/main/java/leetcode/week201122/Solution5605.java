package leetcode.week201122;

public class Solution5605 {

    public static void main(String[] args) {
        Solution5605 solution5605 = new Solution5605();
        solution5605.arrayStringsAreEqual(new String[]{"ab", "c"},
        new String[]{"a", "bc"});
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb1 = new StringBuffer();
        for (String s1 : word1) {
            sb1.append(s1);
        }

        StringBuffer sb2 = new StringBuffer();
        for (String s2 : word2) {
            sb1.append(s2);
        }
        return sb1.toString().equals(sb2.toString());
    }

}
