package leetcode.primary.s2_str;

public class LC387 {
    public int firstUniqChar(String s) {
        int[] table = new int[26];

        for (char c : s.toCharArray()) {
            table[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (table[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
