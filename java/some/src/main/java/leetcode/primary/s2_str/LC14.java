package leetcode.primary.s2_str;

public class LC14 {

    public static void main(String[] args) {
        System.out.println("fasdf".substring(0,0));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int index = 0;
        char c = ' '; // init
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                if (index > str.length() - 1) {
                    return str;
                }
                char temp = str.charAt(index);
                if (i == 0) {
                    c = temp;
                } else {
                    if (temp != c) {
                        return str.substring(0, index);
                    }
                }
            }
            index++;
        }
    }

}
